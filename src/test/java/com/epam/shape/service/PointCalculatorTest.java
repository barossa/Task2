package com.epam.shape.service;

import com.epam.shape.entity.Point;
import com.epam.shape.service.impl.PointCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class PointCalculatorTest {

    @Test
    public void distanceBetweenPoints(){
        double firstVar = new Random().nextDouble();
        double secondVar = new Random().nextDouble();
        Point first = new Point(0,0,firstVar);
        Point second = new Point(0,0, secondVar);
        PointCalcService calcService = new PointCalculatorImpl();

        double expected = firstVar - secondVar;
        if(expected < 0){
            expected*= -1;
        }

        double actual = calcService.calcDistance(first, second);
        Assert.assertEquals(expected, actual, 0.0);
    }
}
