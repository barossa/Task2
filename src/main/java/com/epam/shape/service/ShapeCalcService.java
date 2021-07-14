package com.epam.shape.service;

import com.epam.shape.entity.Point;
import com.epam.shape.exception.ShapeException;

import java.util.List;

public interface ShapeCalcService {
    double calcVolume(List<Point> coordinates) throws ShapeException;
}
