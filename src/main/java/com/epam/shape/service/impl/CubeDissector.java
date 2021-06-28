package com.epam.shape.service.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Planes;
import com.epam.shape.entity.Point;
import com.epam.shape.exception.CubeException;
import com.epam.shape.service.CubeDissectionService;

import java.util.List;

public class CubeDissector implements CubeDissectionService {
    private final Cube cube;
    private final Planes plane;
    private final float distance;

    public CubeDissector(Cube cube, Planes plane, float distance) throws CubeException {
        this.cube = cube;
        this.plane = plane;
        this.distance = distance;
        if(!isCrossed()){
            throw new CubeException("The cube is not crossed by a plane");
        }
    }

    @Override
    public float getVolumesRatio() {
        return 0;
    }

    @Override
    public boolean isVolumesEquals() {
        return false;
    }

    private boolean isCrossed(){
        CubeLocator locator = new CubeLocator();
        List<Point> points = locator.getPoints(cube);
        int dissections = 0;
        for (Point point : points) {
            switch (plane){
                case X:
                    if(point.getX() > distance){
                        dissections++;
                    }
                    break;
                case Y:
                    if(point.getY() > distance){
                        dissections++;
                    }
                    break;

                case Z:
                    if(point.getZ() > distance){
                        dissections++;
                    }
                    break;
            }
        }

        return dissections == 4;
    }
}
