package com.epam.shape.reader.impl;

import com.epam.shape.exception.ShapeException;
import com.epam.shape.reader.ShapeFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeReader implements ShapeFileReader {
    final static Logger logger = LogManager.getLogger(ShapeReader.class);
    private final String filepath;

    public ShapeReader(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public List<String> readLines() throws ShapeException {
        Path path;
        try {
            path = Paths.get(filepath);
        } catch (InvalidPathException e) {
            logger.error(e.getMessage(), e);
            throw new ShapeException("Can't read Shape data", e);
        }

        try {
            return Files.lines(path).collect(Collectors.toList());
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new ShapeException("Error occurred while reading Shape data", e);
        }
    }
}
