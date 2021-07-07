package com.epam.shape.service.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Point;
import com.epam.shape.service.CubeLocationService;

import java.util.List;

public class CubeLocator implements CubeLocationService {

    @Override
    public boolean isOnXPlane(Cube cube) {
        int intersections = 0;
        List<Point> points = cube.getCoordinates();
        for (Point point : points) {
            if (point.getX() == 0D) {
                intersections++;
            }
        }
        return intersections == 4;
    }

    @Override
    public boolean isOnYPlane(Cube cube) {
        int intersections = 0;
        List<Point> points = cube.getCoordinates();
        for (Point point : points) {
            if (point.getY() == 0D) {
                intersections++;
            }
        }
        return intersections == 4;
    }

    @Override
    public boolean isOnZPlane(Cube cube) {
        int intersections = 0;
        List<Point> points = cube.getCoordinates();
        for (Point point : points) {
            if (point.getZ() == 0F) {
                intersections++;
            }
        }
        return intersections == 4;
    }

    @Override
    public boolean isOnTheCenter(Cube cube) {
        Point center = cube.getCenter();
        return center.equals(new Point(0D, 0D, 0D));
    }
}
