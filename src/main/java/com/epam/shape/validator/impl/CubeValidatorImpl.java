package com.epam.shape.validator.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.validator.CubeValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeValidatorImpl implements CubeValidator {
    @Override
    public boolean validate(Cube cube) {
        if(cube.getCenter() == null) {
            return false;
        }
        if(cube.getEdgeLength() <= 0D) {
            return false;
        }
        return true;
    }
}
