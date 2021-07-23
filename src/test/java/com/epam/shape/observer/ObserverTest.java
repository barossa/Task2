package com.epam.shape.observer;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.CubeParameter;
import com.epam.shape.entity.Point;
import com.epam.shape.entity.Warehouse;
import com.epam.shape.exception.CubeException;
import com.epam.shape.observer.impl.CubeObserverImpl;
import com.epam.shape.service.CubeService;
import com.epam.shape.service.impl.CubeCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ObserverTest {

    @Test
    public void cubeDataChanged() throws CubeException {
        Warehouse warehouse = Warehouse.getInstance();

        Cube cube = new Cube(new Point(0, 0, 0), 10D);
        cube.attach(new CubeObserverImpl());
        List<Point> coordinates = CubeService.getPoints(cube);
        CubeCalculator calculator = new CubeCalculator(cube);
        CubeParameter initialParameter = new CubeParameter(coordinates, calculator.calcVolume());
        warehouse.put(cube.getId(), initialParameter);
        System.out.println("Initial: " + initialParameter);

        Point changedCenter = new Point(1.7D, 0, -2.5D);
        cube.setCenter(changedCenter);

        List<Point> expectedCords = CubeService.getPoints(cube);
        double cubeEdge = cube.getEdgeLength();
        double expectedVolume = cubeEdge * cubeEdge * cubeEdge;
        CubeParameter expectedParameter = new CubeParameter(expectedCords, expectedVolume);

        CubeParameter actualParameter = warehouse.get(cube.getId()).get();
        System.out.printf("Expected: %s,\nActual: %s%n", expectedParameter, actualParameter);

        Assert.assertEquals(expectedParameter, actualParameter);
    }
}
