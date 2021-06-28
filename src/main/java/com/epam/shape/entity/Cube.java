package com.epam.shape.entity;

import com.epam.shape.service.IdGenerator;

public class Cube {
    private final long id;
    private Point center;
    private float edgeLength;

    public Cube(Point center,float edgeLength){
        this.id = IdGenerator.getId();
        this.center = center;
        this.edgeLength = edgeLength;
    }

    public long getId() {
        return id;
    }

    public Point getCenter() {
        return new Point(center);
    }

    public void setCenter(Point center) {
        this.center = new Point(center);
    }

    public float getEdgeLength() {
        return edgeLength;
    }

    public void setEdgeLength(float edgeLength) {
        this.edgeLength = edgeLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        if (id != cube.id) return false;
        if (Float.compare(cube.edgeLength, edgeLength) != 0) return false;
        return center.equals(cube.center);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + center.hashCode();
        result = 31 * result + (edgeLength != +0.0f ? Float.floatToIntBits(edgeLength) : 0);
        return result;
    }
}
