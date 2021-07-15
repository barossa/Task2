package com.epam.shape.observer;

import com.epam.shape.exception.CubeException;

public interface CubeObserver {
    void updateParameters(CubeEvent source) throws CubeException;
}
