package com.epam.shape.service;

import com.epam.shape.entity.Shape;
import com.epam.shape.exception.ShapeException;

public interface ShapeCalcService {
    double calcVolume(Shape shape) throws ShapeException;
}
