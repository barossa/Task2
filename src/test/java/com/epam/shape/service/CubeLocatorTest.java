package com.epam.shape.service;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Point;
import com.epam.shape.exception.CubeException;
import com.epam.shape.observer.impl.CubeObserverImpl;
import com.epam.shape.service.impl.CubeLocatorImpl;
import org.junit.Assert;
import org.junit.Test;

public class CubeLocatorTest {

    @Test
    public void onXPlaneTest() throws CubeException {
        Point center = new Point(5,10,5);
        Cube cube = new Cube(center, 10);
        cube.attach(new CubeObserverImpl());
        cube.setCenter(center);

        CubeLocatorImpl locator = new CubeLocatorImpl(cube);
        Assert.assertTrue(locator.isOnXPlane());
    }

    @Test
    public void onYPlaneTest() throws CubeException {
        Point center = new Point(10,5,5);
        Cube cube = new Cube(center, 10);
        cube.attach(new CubeObserverImpl());
        cube.setCenter(center);

        CubeLocatorImpl locator = new CubeLocatorImpl(cube);
        Assert.assertTrue(locator.isOnYPlane());
    }

    @Test
    public void onZPlaneTest() throws CubeException {
        Point center = new Point(5,10,5);
        Cube cube = new Cube(center, 10);
        cube.attach(new CubeObserverImpl());
        cube.setCenter(center);

        CubeLocatorImpl locator = new CubeLocatorImpl(cube);
        Assert.assertTrue(locator.isOnZPlane());
    }
}
