package com.epam.shape.service;

import com.epam.shape.entity.Shape;
import com.epam.shape.exception.CubeException;

public interface CubeDissectionService {
    double getVolumesRatio() throws CubeException;
    boolean isVolumesEquals() throws CubeException;
    Shape getLeftShape();
    Shape getRightShape();
}
