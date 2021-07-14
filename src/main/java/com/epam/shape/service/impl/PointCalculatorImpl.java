package com.epam.shape.service.impl;

import com.epam.shape.entity.Point;
import com.epam.shape.service.PointCalcService;

public class PointCalculatorImpl implements PointCalcService {
    @Override
    public double calcDistance(Point first, Point second) {
        if(first == second || first.equals(second)) return 0D;
        double xDist = Math.pow(first.getX() - second.getX(), 2);
        double yDist = Math.pow(first.getY() - second.getY(), 2);
        double zDist = Math.pow(first.getZ() - second.getZ(), 2);
        return Math.sqrt(xDist + yDist + zDist);
    }
}
