package com.epam.shape;

import com.epam.shape.entity.Cube;
import com.epam.shape.entity.Planes;
import com.epam.shape.entity.Point;
import com.epam.shape.exception.CubeException;
import com.epam.shape.service.impl.CubeDissector;
import com.epam.shape.service.impl.CubeLocator;

public class Main {
    public static void main(String[] args) throws CubeException {
        CubeLocator locator = new CubeLocator();
        Cube cube = new Cube(new Point(),10);
        System.out.println(locator.getPoints(cube));
        System.out.println("Is on the center: " + locator.isOnTheCenter(cube));
        System.out.println("IS on X: " + locator.isOnXPlane(cube));
        System.out.println("IS on Y: " + locator.isOnYPlane(cube));
        System.out.println("IS on Z: " + locator.isOnZPlane(cube));
        CubeDissector dissector = new CubeDissector(cube, Planes.X, 4);
    }
}
