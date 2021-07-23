package com.epam.shape.service.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.exception.CubeException;
import com.epam.shape.service.CubeCalcService;

public class CubeCalculator implements CubeCalcService {
    private final double edge;

    public CubeCalculator(Cube cube) throws CubeException {
        if(cube == null) {
            throw new CubeException("Cube can't be null");
        }
        this.edge = cube.getEdgeLength();
    }

    @Override
    public double calcSurfaceSquare() {
        return 6 * edge * edge;
    }

    @Override
    public double calcVolume() {
        return edge * edge * edge;
    }
}
