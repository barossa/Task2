package com.epam.shape.service;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Point;
import com.epam.shape.entity.Warehouse;
import com.epam.shape.exception.ShapeException;
import com.epam.shape.observer.impl.CubeObserverImpl;
import com.epam.shape.service.impl.ShapeCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Random;

public class ShapeCalculatorTest {

    @Test
    public void volumeCalcTest() throws ShapeException {
        Point center = new Point(new Random().nextDouble(), new Random().nextDouble(), new Random().nextDouble());
        Cube cube = new Cube(center, new Random().nextDouble());
        cube.attach(new CubeObserverImpl());
        cube.setCenter(center);

        ShapeCalculatorImpl calculator = new ShapeCalculatorImpl();
        Warehouse warehouse = Warehouse.getInstance();
        List<Point> coordinates = warehouse.get(cube.getId()).get().getCoordinates();
        double volumeActual = calculator.calcVolume(coordinates);
        double volumeExpected = Math.pow(cube.getEdgeLength(), 3D);

        Assert.assertEquals(volumeExpected, volumeActual, 0.0);
    }
}
