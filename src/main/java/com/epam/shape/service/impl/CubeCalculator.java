package com.epam.shape.service.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.exception.CubeException;
import com.epam.shape.service.CubeCalcService;

public class CubeCalculator implements CubeCalcService {
    private final Cube cube;

    public CubeCalculator(Cube cube) throws CubeException {
        if(cube == null) {
            throw new CubeException("Cube can't be null");
        }
        this.cube = cube;
    }

    @Override
    public double calcSurfaceSquare() {
        return 0;
    }

    @Override
    public double calcVolume() {
        return 0;
    }
}
