package com.epam.shape.service;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Point;

public interface CubeCalcService extends ShapeCalcService {
    double getSurfaceSquare(Cube cube);
}
