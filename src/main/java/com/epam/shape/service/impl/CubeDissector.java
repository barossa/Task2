package com.epam.shape.service.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Planes;
import com.epam.shape.entity.Point;
import com.epam.shape.entity.Shape;
import com.epam.shape.exception.CubeException;
import com.epam.shape.exception.ShapeException;
import com.epam.shape.service.CubeDissectionService;

import java.util.ArrayList;
import java.util.List;

public class CubeDissector implements CubeDissectionService {
    private final Cube cube;
    private final Planes plane;
    private final double distance;
    private Shape first;
    private Shape second;

    public CubeDissector(Cube cube, Planes plane, double distance) throws CubeException {
        this.cube = cube;
        this.plane = plane;
        this.distance = distance;
        if (!isCrossed()) {
            throw new CubeException("The cube is not crossed by a plane");
        }
        try {
            dissectIntoShapes();
        } catch (ShapeException e) {
            throw new CubeException("Error occurred while dissecting cube.", e);
        }
    }

    @Override
    public double getVolumesRatio() throws CubeException {
        ShapeCalculator calculator = new ShapeCalculator();
        double firstVolume, secondVolume;
        try {
            firstVolume = calculator.calcVolume(first);
            secondVolume = calculator.calcVolume(second);
        } catch (ShapeException e) {
            throw new CubeException("Error occurred while calculating volumes.", e);
        }
        return firstVolume / secondVolume;
    }

    @Override
    public boolean isVolumesEquals() throws CubeException {
        return getVolumesRatio() == 1.0D;
    }

    @Override
    public Shape getLeftShape() {
        return new Shape(first);
    }

    @Override
    public Shape getRightShape() {
        return new Shape(second);
    }

    private void dissectIntoShapes() throws ShapeException {
        List<Point> coordinates = cube.getCoordinates();
        List<Point> leftBase = new ArrayList<>(4), rightBase = new ArrayList<>(4);
        Point distPoint = new Point(distance, distance, distance);
        for (Point point : coordinates) {
            if (point.greaterThen(distPoint, plane)) {
                rightBase.add(point);
            } else {
                leftBase.add(point);
            }
        }
        List<Point> leftShape = new ArrayList<>(8);
        for (Point point : leftBase) {
            leftShape.add(point);
            leftShape.add(getCrossingPlanePoint(point));
        }
        List<Point> rightShape = new ArrayList<>(8);
        for (Point point : rightBase) {
            rightShape.add(getCrossingPlanePoint(point));
            rightShape.add(point);
        }
        first = new Shape(leftShape);
        second = new Shape(rightShape);
    }

    private Point getCrossingPlanePoint(Point point) {
        Point result = new Point(point);
        switch (plane) {
            case X:
                result.setX(distance);
                break;
            case Y:
                result.setY(distance);
                break;
            case Z:
                result.setZ(distance);
                break;
        }
        return result;
    }

    private boolean isCrossed() {
        List<Point> points = cube.getCoordinates();
        int dissections = 0;
        for (Point point : points) {
            switch (plane) {
                case X:
                    if (distance >= 0 && point.getX() > distance) {
                        dissections++;
                    } else if (distance < 0 && point.getX() < distance) {
                        dissections++;
                    }
                    break;
                case Y:
                    if (distance >= 0 && point.getY() > distance) {
                        dissections++;
                    } else if (distance < 0 && point.getY() < distance) {
                        dissections++;
                    }
                    break;

                case Z:
                    if (distance >= 0 && point.getZ() > distance) {
                        dissections++;
                    } else if (distance < 0 && point.getZ() < distance) {
                        dissections++;
                    }
                    break;
            }
        }

        return dissections == 4;
    }
}
