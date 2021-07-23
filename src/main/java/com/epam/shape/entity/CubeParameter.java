package com.epam.shape.entity;

import java.util.List;

public class CubeParameter {
    private final List<Point> coordinates;
    private final double volume;

    public CubeParameter(List<Point> coordinates, double volume) {
        this.coordinates = coordinates;
        this.volume = volume;
    }

    public List<Point> getCoordinates() {
        return coordinates;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CubeParameter)) return false;

        CubeParameter parameter = (CubeParameter) o;

        if (Double.compare(parameter.volume, volume) != 0) return false;
        return coordinates.equals(parameter.coordinates);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = coordinates.hashCode();
        temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "CubeParameter{" +
                "coordinates=" + coordinates +
                ", volume=" + volume +
                '}';
    }
}
