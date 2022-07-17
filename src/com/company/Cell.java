package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Cell {
    private int x;
    private int y;
    public int plantAmount;
    public HashSet<Animal> wolves;
    public HashMap<String, HashSet<Animal>> residents = new HashMap<>(){{
        put("Wolf", wolves);
    }};


    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        Random r = new Random();
        this.plantAmount = r.nextInt(200);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
