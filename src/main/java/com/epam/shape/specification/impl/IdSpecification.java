package com.epam.shape.specification.impl;

import com.epam.shape.entity.Cube;
import com.epam.shape.specification.Specification;

public class IdSpecification implements Specification {
    private final long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Cube cube) {
        return id == cube.getId();
    }
}
