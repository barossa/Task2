package com.epam.shape.factory;

import com.epam.shape.entity.Shape;
import com.epam.shape.exception.ShapeException;

public interface ShapeFactory {
    Shape createFromFile() throws ShapeException;
    Shape createFromFile(String filepath) throws ShapeException;
}
