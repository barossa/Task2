package com.epam.shape.comparator;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Point;
import com.epam.shape.service.PointCalcService;
import com.epam.shape.service.impl.PointCalculatorImpl;

import java.util.Comparator;

public class DistanceFromCenterComparator implements Comparator<Cube> {
    @Override
    public int compare(Cube o1, Cube o2) {
        Point center = new Point(0, 0, 0);
        PointCalcService calcService = new PointCalculatorImpl();
        double firstDistance = calcService.calcDistance(center, o1.getCenter());
        double secondDistance = calcService.calcDistance(center, o2.getCenter());
        return Double.compare(firstDistance, secondDistance);
    }
}
