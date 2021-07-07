package com.epam.shape.parser;

import com.epam.shape.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ShapeParserImpl {
    private static final String SPLIT_REGEX = ",";
    private static final int X_POSITION_BY_ORDER = 0;
    private static final int Y_POSITION_BY_ORDER = 1;
    private static final int Z_POSITION_BY_ORDER = 2;
    private static final int STEP_SIZE = 3;
    final static Logger logger = LogManager.getLogger(ShapeParserImpl.class);
    private final String[] data;

    public ShapeParserImpl(String line) {
        data = line.split(SPLIT_REGEX);
        logger.info("Shape parsed successfully -> " + line);
    }

    public List<Point> parseLine() {
        List<Point> points = new ArrayList<>(9);
        for (int i = 0; i <= data.length - STEP_SIZE; i+= STEP_SIZE) {
            double x = Double.parseDouble(data[i + X_POSITION_BY_ORDER]);
            double y = Double.parseDouble(data[i + Y_POSITION_BY_ORDER]);
            double z = Double.parseDouble(data[i + Z_POSITION_BY_ORDER]);
            points.add(new Point(x, y, z));
        }
        logger.debug("Parsed shape data: " + points.size() + "points");
        return points;
    }
}
