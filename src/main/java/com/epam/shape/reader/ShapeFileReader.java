package com.epam.shape.reader;


import com.epam.shape.exception.ShapeException;

import java.util.List;

public interface ShapeFileReader {
    List<String> readLines() throws ShapeException;
}
