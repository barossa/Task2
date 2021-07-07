package com.epam.shape.service.impl;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Shape;
import com.epam.shape.exception.ShapeException;
import com.epam.shape.service.ShapeCalcService;

import java.util.ArrayList;
import java.util.List;

public class ShapeCalculator implements ShapeCalcService {

    @Override
    public double calcVolume(Shape shape) throws ShapeException {
        if (shape == null || shape.getCoordinates().size() < 8) {
            throw new ShapeException("Shape is incorrect!");
        }
        List<Point> coordinates = shape.getCoordinates();
        List<Point> firstBase = new ArrayList<>(4), secondBase = new ArrayList<>(4);
        Point firstPoint = coordinates.get(0);
        for (Point point : coordinates) {
            if (point.getX() == firstPoint.getX()) {
                firstBase.add(point);
            } else {
                secondBase.add(point);
            }
        }
        double yEdgeLength = 0D, zEdgeLength = 0D, xEdgeLength = 0D;
        firstPoint = firstBase.get(0);
        Point secondPoint = secondBase.get(0);
        for (Point point : firstBase) {
            if (point.getY() != firstPoint.getY()) {
                yEdgeLength = Math.abs(point.getY() - firstPoint.getY());
            }
            if (point.getZ() != firstPoint.getZ()) {
                zEdgeLength = Math.abs(point.getZ() - firstPoint.getZ());
            }
            if (point.getZ() == secondPoint.getZ()) {
                if (point.getY() == secondPoint.getY()) {
                    xEdgeLength = Math.abs(point.getX() - secondPoint.getX());
                }
            }
        }
        return xEdgeLength * yEdgeLength * zEdgeLength;
    }
}
