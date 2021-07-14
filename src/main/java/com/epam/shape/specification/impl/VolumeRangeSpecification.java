package com.epam.shape.specification.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.exception.CubeException;
import com.epam.shape.service.CubeCalcService;
import com.epam.shape.service.impl.CubeCalculator;
import com.epam.shape.specification.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VolumeRangeSpecification implements Specification {
    private final double fromVolume;
    private final double toVolume;


    public VolumeRangeSpecification(double fromVolume, double toVolume) {
        this.fromVolume = fromVolume;
        this.toVolume = toVolume;
    }

    @Override
    public boolean specify(Cube cube) {
        double edgeLength = cube.getEdgeLength();
        double volume = edgeLength * edgeLength * edgeLength;
        return volume >= fromVolume && volume <= toVolume;
    }
}
