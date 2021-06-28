package com.epam.shape.service;

public class IdGenerator {
    private static long id = 0;

    private IdGenerator(){
    }

    public static long getId(){
        return ++id;
    }
}
