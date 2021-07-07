package com.epam.shape.factory.impl;

import com.epam.shape.entity.Shape;
import com.epam.shape.exception.ShapeException;
import com.epam.shape.factory.ShapeFactory;
import com.epam.shape.parser.ShapeParserImpl;
import com.epam.shape.reader.impl.ShapeReader;
import com.epam.shape.validator.impl.ShapeValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ShapeFactoryImpl implements ShapeFactory {
    final static Logger logger = LogManager.getLogger(ShapeFactoryImpl.class);
    @Override
    public Shape createFromFile() throws ShapeException {
        return createFromFile("input\\shapes.txt");
    }

    @Override
    public Shape createFromFile(String filepath) throws ShapeException {
        ShapeReader reader = new ShapeReader(filepath);
        List<String> lines = reader.readLines();
        ShapeValidatorImpl shapeValidator = new ShapeValidatorImpl();
        for (String line : lines) {
            if (shapeValidator.validateData(line)) {
                ShapeParserImpl parser = new ShapeParserImpl(line);
                logger.info("Shape created successfully!");
                return new Shape(parser.parseLine());
            }
        }
        logger.error("Shape is null! Check filepath or file integrity");
        throw new ShapeException("Can't create shape. Input data error");
    }
}
