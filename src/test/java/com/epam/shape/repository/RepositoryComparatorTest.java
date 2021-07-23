package com.epam.shape.repository;

import com.epam.shape.comparator.DistanceFromCenterComparator;
import com.epam.shape.comparator.IdComparator;
import com.epam.shape.comparator.VolumeComparator;
import com.epam.shape.entity.*;
import com.epam.shape.exception.CubeException;
import com.epam.shape.observer.impl.CubeObserverImpl;
import com.epam.shape.service.PointCalcService;
import com.epam.shape.service.impl.PointCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class RepositoryComparatorTest {

    @Test
    public void distanceFromCenterSort() throws CubeException {
        RepositorySpecificationTest.fillRepository(20);
        CubeRepository repository = CubeRepository.getInstance();

        repository.add(new Cube(new Point(0,0,0), 1D));

        repository.sort(new DistanceFromCenterComparator());

        List<Cube> cubesList = repository.getAsList();
        Cube firstCube = cubesList.get(0);
        Point firstCubeCenter = firstCube.getCenter();
        PointCalcService calcService = new PointCalculatorImpl();
        double distanceFromCenter = calcService.calcDistance(new Point(0,0,0), firstCubeCenter);

        Assert.assertEquals(0D, distanceFromCenter, 0.0);

    }

    @Test
    public void idSort() throws CubeException {
        RepositorySpecificationTest.fillRepository(20);
        CubeRepository repository = CubeRepository.getInstance();

        repository.sort(new IdComparator());

        List<Cube> cubesList = repository.getAsList();
        Cube cube = cubesList.get(0);
        double expectedId = 1;

        Assert.assertEquals(expectedId, cube.getId(), 0.0);

    }

    @Test
    public void volumeSort() throws CubeException {
        RepositorySpecificationTest.fillRepository(20);
        CubeRepository repository = CubeRepository.getInstance();

        Cube cube = new Cube(new Point(0, 0, 0), 1D);
        cube.attach(new CubeObserverImpl());
        cube.setEdgeLength(10D);
        repository.add(cube);

        repository.sort(new VolumeComparator());

        List<Cube> cubesList = repository.getAsList();
        Cube firstCube = cubesList.get(0);
        Cube lastCube = cubesList.get(cubesList.size() - 1);

        Warehouse warehouse = Warehouse.getInstance();

        Optional<CubeParameter> firstOptional = warehouse.get(firstCube.getId());
        Optional<CubeParameter> lastOptional = warehouse.get(lastCube.getId());

        double firstVolume = firstOptional.get().getVolume();
        double lastVolume = lastOptional.get().getVolume();

        Assert.assertTrue(firstVolume <= lastVolume);

    }

}
