package com.epam.shape.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Warehouse {
    private static Warehouse instance;
    private final Map<Long, CubeParameter> parametersMap = new HashMap();

    private Warehouse(){
    }

    public static Warehouse getInstance() {
        if(instance == null){
            instance = new Warehouse();
        }
        return instance;
    }

    public CubeParameter put(long id, CubeParameter parameter){
        return parametersMap.put(id, parameter);
    }

    public Optional<CubeParameter> get(long id){
        CubeParameter parameter = parametersMap.get(id);
        return (parameter == null ? Optional.empty() : Optional.of(parameter));
    }

    public Optional<CubeParameter> remove(long id){
        CubeParameter parameter = parametersMap.remove(id);
        return (parameter == null ? Optional.empty() : Optional.of(parameter));
    }
}
