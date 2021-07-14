package com.epam.shape.specification.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Point;
import com.epam.shape.service.PointCalcService;
import com.epam.shape.service.impl.PointCalculatorImpl;
import com.epam.shape.specification.Specification;

public class DistanceRangeFromCenter implements Specification {
    private final double fromDistance;
    private final double toDistance;

    public DistanceRangeFromCenter(double fromDistance, double toDistance) {
        this.fromDistance = fromDistance;
        this.toDistance = toDistance;
    }

    @Override
    public boolean specify(Cube cube) {
        Point cubeCenter = cube.getCenter();
        Point center = new Point(0, 0, 0);
        PointCalcService calcService = new PointCalculatorImpl();
        double distanceFromCenter = calcService.calcDistance(center, cubeCenter);
        return distanceFromCenter >= fromDistance && distanceFromCenter <= toDistance;
    }
}
