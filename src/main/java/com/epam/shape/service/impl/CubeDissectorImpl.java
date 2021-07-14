package com.epam.shape.service.impl;

import com.epam.shape.entity.*;
import com.epam.shape.exception.CubeException;
import com.epam.shape.exception.ShapeException;
import com.epam.shape.service.CubeDissectionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CubeDissectorImpl implements CubeDissectionService {
    final static Logger logger = LogManager.getLogger(CubeDissectorImpl.class);
    private final CubeParameter cubeParameter;
    private final Planes plane;
    private final double distance;
    private List<Point> leftShape;
    private List<Point> rightShape;

    public CubeDissectorImpl(Cube cube, Planes plane, double distance) throws CubeException {
        Warehouse warehouse = Warehouse.getInstance();
        Optional<CubeParameter> optional = warehouse.get(cube.getId());
        cubeParameter =  optional.orElseThrow(() -> new CubeException("Warehouse doesn't contain cube parameter"));
        this.plane = plane;
        this.distance = distance;
        if (!isCrossed()) {
            logger.error("Cube is not crossed by a plane");
            throw new CubeException("The cube is not crossed by a plane");
        }
        dissectIntoShapes();
    }

    @Override
    public double getVolumesRatio() throws CubeException {
        ShapeCalculatorImpl calculator = new ShapeCalculatorImpl();
        double firstVolume, secondVolume;
        try {
            firstVolume = calculator.calcVolume(leftShape);
            secondVolume = calculator.calcVolume(rightShape);
        } catch (ShapeException e) {
            throw new CubeException("Error occurred while calculating volumes.", e);
        }
        return firstVolume / secondVolume;
    }

    private void dissectIntoShapes() {
        List<Point> coordinates = cubeParameter.getCoordinates();
        List<Point> leftBase = new ArrayList<>(4), rightBase = new ArrayList<>(4);
        Point distPoint = new Point(distance, distance, distance);
        for (Point point : coordinates) {
            if (point.greaterThen(distPoint, plane)) {
                rightBase.add(point);
            } else {
                leftBase.add(point);
            }
        }
        leftShape = new ArrayList<>(8);
        for (Point point : leftBase) {
            leftShape.add(point);
            leftShape.add(getCrossingPlanePoint(point));
        }
        rightShape = new ArrayList<>(8);
        for (Point point : rightBase) {
            rightShape.add(getCrossingPlanePoint(point));
            rightShape.add(point);
        }
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
        List<Point> points = cubeParameter.getCoordinates();
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
