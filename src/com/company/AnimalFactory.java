package com.company;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadFactory;

public class AnimalFactory {

    public static Animal create(String className, int x, int y, Island island) {
        return switch (className) {
            case "Wolf" -> new Wolf(x, y, className + Wolf.count.getAndIncrement(), island);
            case "Rabbit" -> new Rabbit(x, y, className + Rabbit.count.getAndIncrement(), island);
            default -> throw new IllegalStateException("Unexpected value");
        };
    }
}
