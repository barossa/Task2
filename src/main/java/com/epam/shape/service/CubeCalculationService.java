package com.epam.shape.service;

import com.epam.shape.entity.Cube;

public interface CubeCalculationService {
    float getSurfaceSquare(Cube cube);
    float getVolume(Cube cube);
}
