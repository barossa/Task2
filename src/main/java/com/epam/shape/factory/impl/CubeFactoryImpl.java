package com.epam.shape.factory.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Point;
import com.epam.shape.exception.CubeException;
import com.epam.shape.factory.CubeFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.shape.parser.LinePositions.*;

public class CubeFactoryImpl implements CubeFactory {
    final static Logger logger = LogManager.getLogger(CubeFactoryImpl.class);

    @Override
    public Cube createCube(double[] parameters) throws CubeException {
        if (parameters == null || parameters.length < ELEMENT_COUNT) {
            logger.error("Can't create cube from invalid parameters");
            throw new CubeException("Invalid parameters");
        }
        Point center = new Point(parameters[X_CORD_POSITION],
                parameters[Y_CORD_POSITION],
                parameters[Z_CORD_POSITION]);
        Cube cube = new Cube(center, parameters[EDGE_LENGTH_POSITION]);
        logger.info("Cube is created successfully -> " + cube);
        return cube;
    }
}
