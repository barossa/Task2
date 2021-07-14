package com.epam.shape.comparator;

import com.epam.shape.entity.Cube;

import java.util.Comparator;

public class IdComparator implements Comparator<Cube> {
    @Override
    public int compare(Cube o1, Cube o2) {
        long first = o1.getId();
        long second = o2.getId();
        return Long.compare(first, second);
    }
}
