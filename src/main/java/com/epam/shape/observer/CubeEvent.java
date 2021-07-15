package com.epam.shape.observer;

import com.epam.shape.entity.Cube;

import java.util.EventObject;

public class CubeEvent extends EventObject {
    public CubeEvent(Object source) {
        super(source);
    }

    @Override
    public Cube getSource() {
        return (Cube) super.getSource();
    }
}
