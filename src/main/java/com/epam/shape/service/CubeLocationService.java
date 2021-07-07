package com.epam.shape.service;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Point;

import java.util.List;

public interface CubeLocationService {
    boolean isOnXPlane(Cube cube);
    boolean isOnYPlane(Cube cube);
    boolean isOnZPlane(Cube cube);
    boolean isOnTheCenter(Cube cube);
}
