package com.epam.shape.entity;

import com.epam.shape.specification.Specification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public void sort(Comparator<Cube> comparator){
        cubes.sort(comparator);
    }

    public List<Cube> findBySpecification(Specification specification){
        return cubes.stream().filter(specification::specify).collect(Collectors.toList());
    }

}
