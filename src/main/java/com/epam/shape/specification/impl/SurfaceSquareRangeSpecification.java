package com.epam.shape.specification.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.specification.Specification;

public class SurfaceSquareRangeSpecification implements Specification {
    private final double fromSquare;
    private final double toSquare;

    public SurfaceSquareRangeSpecification(double fromSquare, double toSquare) {
        this.fromSquare = fromSquare;
        this.toSquare = toSquare;
    }

    @Override
    public boolean specify(Cube cube) {
        double edgeLength = cube.getEdgeLength();
        double square = 6D * edgeLength * edgeLength;
        return square >= fromSquare && square <= toSquare;
    }
}
