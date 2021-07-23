package com.epam.shape.entity;

import com.epam.shape.observer.CubeEvent;
import com.epam.shape.observer.CubeObservable;
import com.epam.shape.observer.CubeObserver;
import com.epam.shape.parser.CubeParser;
import com.epam.shape.service.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Cube implements CubeObservable {
    final static Logger logger = LogManager.getLogger(Cube.class);
    private final long id;
    private Point center;
    private double edgeLength;

    private final List<CubeObserver> observerList;

    public Cube(Point center, double edgeLength) {
        this.id = IdGenerator.getId();
        this.center = center;
        this.edgeLength = edgeLength;
        this.observerList = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public Point getCenter() {
        return new Point(center);
    }

    public double getEdgeLength() {
        return edgeLength;
    }

    public void setCenter(Point center) {
        if(center == null) {
            logger.error("Cube[" + id + "] center can't be null!");
            return;
        }
        this.center = center;
        notifyObservers();
    }

    public void setEdgeLength(double edgeLength) {
        if(edgeLength <= 0){
            logger.error("Cube[" + id + "] edge can't be negative(<=0) !");
            return;
        }
        this.edgeLength = edgeLength;
        notifyObservers();
    }

    @Override
    public void attach(CubeObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(CubeObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        CubeEvent event = new CubeEvent(this);
        observerList.forEach(observer -> observer.updateParameters(event));
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
