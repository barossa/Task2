package com.epam.shape.service.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Point;
import com.epam.shape.service.CubeLocationService;

import java.util.ArrayList;
import java.util.List;

public class CubeLocator implements CubeLocationService {
    @Override
    public List<Point> getPoints(Cube cube) {
        List<Point> pointList = new ArrayList<>();
        float edgeLength = cube.getEdgeLength();
        float halfEdge = edgeLength / 2;
        Point point = cube.getCenter();
        point.setZ(point.getZ() - halfEdge);   // lower edge
        point.setX(point.getX() + halfEdge);
        point.setY(point.getY() - halfEdge);   // - A
        pointList.add(new Point(point));
        point.setX(point.getX() - edgeLength); // - B
        pointList.add(new Point(point));
        point.setY(point.getY() + edgeLength); // - C
        pointList.add(new Point(point));
        point.setX(point.getX() + edgeLength); // - D
        pointList.add(new Point(point));

        List<Point> result = new ArrayList<>(pointList);
        for(Point current : pointList){        // A1-D1
            result.add(new Point(current.getX(), current.getY(), current.getZ() + edgeLength));
        }

        return result;
    }

    @Override
    public boolean isOnXPlane(Cube cube) {
        int intersections = 0;
        List<Point> points = getPoints(cube);
        for (Point point : points){
            if(point.getX() == 0F){
                intersections++;
            }
        }
        return intersections == 4;
    }

    @Override
    public boolean isOnYPlane(Cube cube) {
        int intersections = 0;
        List<Point> points = getPoints(cube);
        for (Point point : points){
            if(point.getY() == 0F){
                intersections++;
            }
        }
        return intersections == 4;
    }

    @Override
    public boolean isOnZPlane(Cube cube) {
        int intersections = 0;
        List<Point> points = getPoints(cube);
        for (Point point : points){
            if(point.getZ() == 0F){
                intersections++;
            }
        }
        return intersections == 4;
    }

    @Override
    public boolean isOnTheCenter(Cube cube) {
        Point center = cube.getCenter();
        return center.equals(new Point(0F,0F,0F));
    }
}
