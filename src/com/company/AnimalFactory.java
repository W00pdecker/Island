package com.company;

import java.lang.reflect.InvocationTargetException;

public class AnimalFactory {
    public static Animal create(Class aClass, int x, int y) {
        String name = aClass.getName() + aClass.count.incrementAndGet().toString();
        try {
            return (aClass) aClass.getDeclaredConstructor(int.class, int.class, String.class).newInstance(x, y, name);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
