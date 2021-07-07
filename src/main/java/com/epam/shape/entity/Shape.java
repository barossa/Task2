package com.epam.shape.entity;

import com.epam.shape.exception.ShapeException;
import com.epam.shape.service.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Shape {
    private final long id;
    private final List<Point> coordinates;

    public Shape(List<Point> coordinates) throws ShapeException {
        if(coordinates == null || coordinates.size() < 8)
            throw new ShapeException("Input coordinates list are incorrect!");
        this.id = IdGenerator.getId();
        this.coordinates = new ArrayList<>(coordinates);

    }

    public Shape(Shape shape) {
        this.id = IdGenerator.getId();
        this.coordinates = shape.getCoordinates();
    }

    public List<Point> getCoordinates() {
        return new ArrayList<>(coordinates);
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;

        Shape shape = (Shape) o;

        return coordinates != null ? coordinates.equals(shape.coordinates) : shape.coordinates == null;
    }

    @Override
    public int hashCode() {
        return coordinates != null ? coordinates.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "coordinates=" + coordinates +
                '}';
    }
}
