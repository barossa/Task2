package com.epam.shape.parser;

import com.epam.shape.entity.Point;
import com.epam.shape.factory.impl.CubeFactoryImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeParserImpl {
    private static final String SPLIT_REGEX = ",";
    private static final int X_CORD_POSITION = 0;
    private static final int Y_CORD_POSITION = 1;
    private static final int Z_CORD_POSITION = 2;
    private static final int EDGE_LENGTH_POSITION = 3;
    final static Logger logger = LogManager.getLogger(CubeParserImpl.class);

    private final String[] data;

    public CubeParserImpl(String line) {
        this.data = line.split(SPLIT_REGEX);
        logger.info("Cube parsed successfully -> " + line);
    }

    public Point parseCenter() {
        double x = Double.parseDouble(data[X_CORD_POSITION]);
        double y = Double.parseDouble(data[Y_CORD_POSITION]);
        double z = Double.parseDouble(data[Z_CORD_POSITION]);
        return new Point(x, y, z);
    }

    public double parseEdgeLength() {
        return Double.parseDouble(data[EDGE_LENGTH_POSITION]);
    }
}
