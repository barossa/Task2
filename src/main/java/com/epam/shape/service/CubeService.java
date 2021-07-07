package com.epam.shape.service;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Point;

import java.util.ArrayList;
import java.util.List;

public class CubeService {
    private CubeService(){
    }

    public static List<Point> getPoints(Cube cube){
        return getPoints(cube.getCenter(), cube.getEdgeLength());
    }
    public static List<Point> getPoints(Point center, double edgeLength) {
        List<Point> centerList = new ArrayList<>();
        double halfEdge = edgeLength / 2;
        center.setZ(center.getZ() - halfEdge);   // lower base
        center.setX(center.getX() + halfEdge);
        center.setY(center.getY() - halfEdge);   // - A
        centerList.add(new Point(center));
        center.setX(center.getX() - edgeLength); // - B
        centerList.add(new Point(center));
        center.setY(center.getY() + edgeLength); // - C
        centerList.add(new Point(center));
        center.setX(center.getX() + edgeLength); // - D
        centerList.add(new Point(center));

        List<Point> result = new ArrayList<>(centerList);
        for(Point current : centerList){        // A1-D1
            result.add(new Point(current.getX(), current.getY(), current.getZ() + edgeLength));
        }

        return result;
    }
}
