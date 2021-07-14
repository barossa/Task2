package com.epam.shape.factory;

import com.epam.shape.entity.Cube;
import com.epam.shape.exception.CubeException;

public interface CubeFactory {
    Cube createCube(double[] parameters) throws CubeException;

}
