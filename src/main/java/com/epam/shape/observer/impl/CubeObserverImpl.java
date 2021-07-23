package com.epam.shape.observer.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.CubeParameter;
import com.epam.shape.entity.Point;
import com.epam.shape.entity.Warehouse;
import com.epam.shape.observer.CubeEvent;
import com.epam.shape.observer.CubeObserver;
import com.epam.shape.service.CubeService;
import com.epam.shape.service.PointCalcService;
import com.epam.shape.service.impl.PointCalculatorImpl;
import com.epam.shape.validator.impl.CubeValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CubeObserverImpl implements CubeObserver {
    static final Logger logger = LogManager.getLogger(CubeObserverImpl.class);

    @Override
    public void updateParameters(CubeEvent source) {
        Cube cube = source.getSource();
        CubeValidatorImpl validator = new CubeValidatorImpl();
        if (!validator.validate(cube)) {
            logger.error("Incorrect cube with id " + cube.getId() + ". Update operation failed!");
            return;
        }
        double edge = cube.getEdgeLength();
        double volume = edge * edge * edge;
        List<Point> points = CubeService.getPoints(cube);
        PointCalcService calcService = new PointCalculatorImpl();
        CubeParameter parameter = new CubeParameter(points, volume);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(cube.getId(), parameter);
        logger.info("Parameters for Cube id-" + cube.getId() + " updated!");
    }
}
