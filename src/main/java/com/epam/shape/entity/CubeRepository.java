package com.epam.shape.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CubeRepository {
    private static CubeRepository instance;
    private final List<Cube> cubes = new ArrayList<>();

    private CubeRepository() {
    }

    public static CubeRepository getInstance() {
        if (instance == null) {
            instance = new CubeRepository();
        }
        return instance;
    }

    public void add(Cube cube){
        cubes.add(cube);
    }

    public void addAll(Collection<? extends Cube> cubes){
        this.cubes.addAll(cubes);
    }

    public void remove(Cube cube){
        cubes.remove(cube);
    }

    public void set(int id, Cube cube){
        cubes.set(id, cube);
    }

    public void clear(){
        cubes.clear();
    }

    public int size(){
        return cubes.size();
    }

}
