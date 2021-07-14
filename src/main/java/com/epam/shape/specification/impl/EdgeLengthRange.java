package com.epam.shape.specification.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.specification.Specification;

public class EdgeLengthRange implements Specification {
    private final double fromLength;
    private final double toLength;

    public EdgeLengthRange(double fromLength, double toLength) {
        this.fromLength = fromLength;
        this.toLength = toLength;
    }

    @Override
    public boolean specify(Cube cube) {
        double length = cube.getEdgeLength();
        return length >= fromLength && length <= toLength;
    }
}
