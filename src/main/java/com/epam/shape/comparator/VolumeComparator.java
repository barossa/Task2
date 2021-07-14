package com.epam.shape.comparator;

import com.epam.shape.entity.Cube;

import java.util.Comparator;

public class VolumeComparator implements Comparator<Cube> {
    @Override
    public int compare(Cube o1, Cube o2) {
        double firstEdge = o1.getEdgeLength();
        double secondEdge = o2.getEdgeLength();
        double firstVolume = firstEdge * firstEdge * firstEdge;
        double secondVolume = secondEdge * secondEdge * secondEdge;
        return Double.compare(firstVolume, secondVolume);
    }
}
