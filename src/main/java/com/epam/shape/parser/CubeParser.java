package com.epam.shape.parser;

import com.epam.shape.entity.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epam.shape.parser.LinePositions.*;

public class CubeParser {
    private static final String SPLIT_REGEX = ",";
    static final Logger logger = LogManager.getLogger(CubeParser.class);

    private final String[] data;

    public CubeParser(String line) {
        this.data = line.split(SPLIT_REGEX);
        logger.info("Cube parsed successfully -> " + line);
    }

    public double[] parse() {
        double[] result = new double[ELEMENT_COUNT];
        result[X_CORD_POSITION] = Double.parseDouble(data[X_CORD_POSITION]);
        result[Y_CORD_POSITION] = Double.parseDouble(data[Y_CORD_POSITION]);
        result[Z_CORD_POSITION] = Double.parseDouble(data[Z_CORD_POSITION]);
        result[EDGE_LENGTH_POSITION] = Double.parseDouble(data[EDGE_LENGTH_POSITION]);
        return result;
    }

    public double parseEdgeLength() {
        return Double.parseDouble(data[EDGE_LENGTH_POSITION]);
    }
}
