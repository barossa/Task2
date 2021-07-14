package com.epam.shape.service.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.CubeParameter;
import com.epam.shape.entity.Point;
import com.epam.shape.entity.Warehouse;
import com.epam.shape.exception.CubeException;
import com.epam.shape.service.CubeLocationService;

import java.util.List;
import java.util.Optional;

public class CubeLocatorImpl implements CubeLocationService {
    private final CubeParameter parameter;

    public CubeLocatorImpl(Cube cube) throws CubeException {
        Warehouse warehouse = Warehouse.getInstance();
        Optional<CubeParameter> optional = warehouse.get(cube.getId());
        parameter = optional.orElseThrow(() -> new CubeException("Warehouse doesn't contain cube parameter"));
    }


    @Override
    public boolean isOnXPlane() {
        int intersections = 0;
        List<Point> points = parameter.getCoordinates();
        for (Point point : points) {
            if (point.getX() == 0D) {
                intersections++;
            }
        }
        return intersections == 4;
    }

    @Override
    public boolean isOnYPlane() {
        int intersections = 0;
        List<Point> points = parameter.getCoordinates();
        for (Point point : points) {
            if (point.getY() == 0D) {
                intersections++;
            }
        }
        return intersections == 4;
    }

    @Override
    public boolean isOnZPlane() {
        int intersections = 0;
        List<Point> points = parameter.getCoordinates();
        for (Point point : points) {
            if (point.getZ() == 0F) {
                intersections++;
            }
        }
        return intersections == 4;
    }

}
