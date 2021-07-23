package com.epam.shape.service;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.CubeParameter;
import com.epam.shape.entity.Point;
import com.epam.shape.entity.Warehouse;
import com.epam.shape.exception.CubeException;
import com.epam.shape.observer.impl.CubeObserverImpl;
import com.epam.shape.service.impl.CubeCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class CubeCalculatorTest {

    @Test
    public void surfaceSquare() throws CubeException {
        Point center = new Point(new Random().nextDouble(),new Random().nextDouble(),new Random().nextDouble());
        Cube cube = new Cube(center, new Random().nextDouble());

        CubeCalculator calculator = new CubeCalculator(cube);
        double actual = calculator.calcSurfaceSquare();
        double expected = Math.pow(cube.getEdgeLength(), 2D) * 6D;
        Assert.assertEquals(expected, actual, 0.0);
    }

    @Test
    public void volumeTest() throws CubeException {
        Point center = new Point(new Random().nextDouble(),new Random().nextDouble(),new Random().nextDouble());
        Cube cube = new Cube(center, new Random().nextDouble());
        cube.attach(new CubeObserverImpl());
        cube.setCenter(center);

        CubeCalculator calculator = new CubeCalculator(cube);
        double actual = calculator.calcVolume();
        double expected = Math.pow(cube.getEdgeLength(), 3D);
        Assert.assertEquals(expected, actual, 0.0);

    }
}
