package com.epam.shape.service;

import com.epam.shape.exception.CubeException;

public interface CubeDissectionService {
    double getVolumesRatio() throws CubeException;
}
