package com.epam.shape.entity;

public class Point {
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(Point point){
        this.x = point.getX();
        this.y = point.getY();
        this.z = point.getZ();
    }

    public Point(){
        this.x = 0F;
        this.y = 0F;
        this.z = 0F;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public boolean greaterThen(Point point, Planes byPlane){
        if(byPlane == null) return false;
        switch (byPlane){
            case X:
                if(x > point.getX()){
                    return true;
                }
                break;
            case Y:
                if(y > point.getY()){
                    return true;
                }
                break;
            case Z:
                if(z > point.getZ()) {
                    return true;
                }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (Double.compare(point.x, x) != 0) return false;
        if (Double.compare(point.y, y) != 0) return false;
        return Double.compare(point.z, z) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ",y=" + y +
                ",z=" + z +
                '}';
    }
}
