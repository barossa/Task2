package com.epam.shape;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Shape;
import com.epam.shape.exception.ShapeException;
import com.epam.shape.factory.impl.CubeFactoryImpl;
import com.epam.shape.factory.impl.ShapeFactoryImpl;

public class Main {
    public static void main(String[] args) {
        /*CubeFactoryImpl cubeFactory = new CubeFactoryImpl();
        Cube cube = cubeFactory.createFromFile();*/
        ShapeFactoryImpl factory = new ShapeFactoryImpl();
        Shape shape = null;
        try {
            shape = factory.createFromFile();
        } catch (ShapeException e) {
            e.printStackTrace();
        }
        System.out.println(shape);
        //System.out.println(cube);

    }
}
