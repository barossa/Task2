package com.epam.shape.entity;

import com.epam.shape.exception.ShapeException;
import com.epam.shape.service.CubeService;

public class Cube extends Shape {
    private final Point center;
    private final double edgeLength;

    public Cube(Point center, double edgeLength) throws ShapeException {
        super(CubeService.getPoints(center, edgeLength));
        this.center = center;
        this.edgeLength = edgeLength;
    }

    public Point getCenter() {
        return new Point(center);
    }

    public double getEdgeLength() {
        return edgeLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cube)) return false;
        if (!super.equals(o)) return false;

        Cube cube = (Cube) o;

        if (Double.compare(cube.edgeLength, edgeLength) != 0) return false;
        return center.equals(cube.center);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + center.hashCode();
        temp = Double.doubleToLongBits(edgeLength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Cube{" +
                ", center=" + center +
                ", edgeLength=" + edgeLength +
                '}';
    }
}
