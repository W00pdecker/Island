package com.company;

import java.lang.reflect.InvocationTargetException;

public class AnimalFactory {
    public static Animal create(String className, int x, int y, Island island) {
        return switch (className) {
            case "Wolf" -> new Wolf(x, y, className + Wolf.count.getAndIncrement(), island);
        };
    }
}
