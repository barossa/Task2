package com.epam.shape.factory.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Point;
import com.epam.shape.exception.CubeException;
import com.epam.shape.exception.ShapeException;
import com.epam.shape.factory.ShapeFactory;
import com.epam.shape.parser.CubeParserImpl;
import com.epam.shape.reader.impl.ShapeReader;
import com.epam.shape.validator.impl.CubeValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CubeFactoryImpl implements ShapeFactory {
    final static Logger logger = LogManager.getLogger(CubeFactoryImpl.class);

    @Override
    public Cube createFromFile() throws CubeException {
        return createFromFile("input\\cubes.txt");
    }

    @Override
    public Cube createFromFile(String filepath) throws CubeException {
        ShapeReader reader = new ShapeReader(filepath);
        List<String> lines;
        try {
            lines = reader.readLines();
        } catch (ShapeException e) {
            logger.error("Can't create Cube", e);
            throw new CubeException("Error occurred while creating Cube", e);
        }
        CubeValidatorImpl validator = new CubeValidatorImpl();
        Cube cube = null;
        for (String line : lines) {
            if (validator.validateData(line)) {
                CubeParserImpl parser = new CubeParserImpl(line);
                try {
                    cube = new Cube(parser.parseCenter(),
                            parser.parseEdgeLength());
                } catch (ShapeException e) {
                    logger.error("Can't create Cube" + e);
                    throw new CubeException("Can't create Cube" + e);
                }
            }
        }
        if(cube == null) throw new CubeException("Cube creation error! Incorrect input data.");
        Point center = cube.getCenter();
        logger.info(String.format("Cube created: Center[%f,%f,%f], Edge:%f",
                center.getX(),
                center.getY(),
                center.getZ(),
                cube.getEdgeLength()));
        return cube;
    }
}
