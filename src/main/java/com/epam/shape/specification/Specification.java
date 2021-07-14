package com.epam.shape.specification;

import com.epam.shape.entity.Cube;

public interface Specification {
    boolean specify(Cube cube);
}
