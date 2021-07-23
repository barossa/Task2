package com.epam.shape.service;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Planes;
import com.epam.shape.entity.Point;
import com.epam.shape.exception.CubeException;
import com.epam.shape.observer.impl.CubeObserverImpl;
import com.epam.shape.service.impl.CubeDissectorImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class CubeDissectorTest {

    @Test
    public void equalsPartsTest() throws CubeException {
        Point center = new Point(new Random().nextDouble(), new Random().nextDouble(), new Random().nextDouble());

        Cube cube = new Cube(center, new Random().nextDouble());
        cube.attach(new CubeObserverImpl());
        cube.setCenter(center);

        double edge = cube.getEdgeLength();

        double dissectDistance = center.getX() - edge / 2D;

        CubeDissectorImpl dissector = new CubeDissectorImpl(cube, Planes.X, dissectDistance);

        Assert.assertTrue(dissector.getVolumesRatio() == 1.0D);
    }
}
