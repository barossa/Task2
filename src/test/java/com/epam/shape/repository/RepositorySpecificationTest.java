package com.epam.shape.repository;

import com.epam.shape.entity.*;
import com.epam.shape.exception.CubeException;
import com.epam.shape.service.CubeService;
import com.epam.shape.service.impl.CubeCalculator;
import com.epam.shape.specification.impl.DistanceRangeFromCenter;
import com.epam.shape.specification.impl.EdgeLengthRange;
import com.epam.shape.specification.impl.SurfaceSquareRangeSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RepositorySpecificationTest {
    private final static double RAND_POINT_FROM_VALUE = -1000D;
    private final static double RAND_POINT_TO_VALUE = 1000D;
    private final static double RAND_EDGE_TO_VALUE = 250D;
    private final static int X_CORD_POS = 0;
    private final static int Y_CORD_POS = 1;
    private final static int Z_CORD_POS = 2;
    private final static int PLANES = 3;


    @Test
    public void findByDistanceFromCenter() throws CubeException {
        CubeRepository repository = CubeRepository.getInstance();
        fillRepository(15);
        DistanceRangeFromCenter rangeFromCenter = new DistanceRangeFromCenter(3D, 600D);
        List<Cube> bySpecification = repository.findBySpecification(rangeFromCenter);

        if (bySpecification.isEmpty()) {
            Point specifiedCenter = new Point(4D, 0D, 0D);
            Cube cube = new Cube(specifiedCenter, 10D);
            repository.add(cube);
            bySpecification = repository.findBySpecification(rangeFromCenter);
        }

        Assert.assertFalse(bySpecification.isEmpty());
        System.out.println(bySpecification);
    }

    @Test
    public void findByEdgeLength() throws CubeException {
        CubeRepository repository = CubeRepository.getInstance();
        fillRepository(20);
        EdgeLengthRange specification = new EdgeLengthRange(10D, 100D);
        List<Cube> bySpecification = repository.findBySpecification(specification);

        if (bySpecification.isEmpty()) {
            Point specifiedCenter = new Point(0D, 0D, 0D);
            Cube cube = new Cube(specifiedCenter, 15D);
            repository.add(cube);
            bySpecification = repository.findBySpecification(specification);
        }

        Assert.assertFalse(bySpecification.isEmpty());
        System.out.println(bySpecification);
    }

    @Test
    public void findBySurfaceSquare() throws CubeException {
        CubeRepository repository = CubeRepository.getInstance();
        fillRepository(20);
        SurfaceSquareRangeSpecification specification = new SurfaceSquareRangeSpecification(5000D, 10000D);
        List<Cube> bySpecification = repository.findBySpecification(specification);

        if (bySpecification.isEmpty()) {
            Point specifiedCenter = new Point(0D, 0D, 0D);
            Cube cube = new Cube(specifiedCenter, 45D);
            repository.add(cube);
            bySpecification = repository.findBySpecification(specification);
        }

        Assert.assertFalse(bySpecification.isEmpty());
        System.out.println(bySpecification);
    }

    public static void fillRepository(int objectsQuantity) throws CubeException {
        CubeRepository repository = CubeRepository.getInstance();
        Warehouse warehouse = Warehouse.getInstance();
        double[] doubles = new Random().doubles(RAND_POINT_FROM_VALUE, RAND_POINT_TO_VALUE)
                .limit(PLANES * (long) objectsQuantity)
                .toArray();

        List<Point> points = new ArrayList<>(objectsQuantity);
        for (int i = 0; i < doubles.length; i += PLANES) {
            Point point = new Point(doubles[i + X_CORD_POS],
                    doubles[i + Y_CORD_POS],
                    doubles[i + Z_CORD_POS]);
            points.add(point);
        }

        double[] edges = new Random().doubles(0D, RAND_EDGE_TO_VALUE)
                .limit(objectsQuantity)
                .toArray();

        for (int i = 0; i < objectsQuantity; i++) {
            Cube cube = new Cube(points.get(i), edges[i]);
            CubeCalculator calculator = new CubeCalculator(cube);
            CubeParameter parameter = new CubeParameter(CubeService.getPoints(cube),
                    calculator.calcVolume());
            repository.add(cube);
            warehouse.put(cube.getId(), parameter);
        }
    }
}
