package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Cell {
    private int x;
    private int y;
    private Island island;
    public int plantAmount;
    public HashSet<Animal> wolves = new HashSet<>();
    public HashSet<Animal>  rabbits = new HashSet<>();
    public HashMap<String, HashSet<Animal>> residents = new HashMap<>(){{
        put("Wolf", wolves);
        put("Rabbit", rabbits);
    }};


    public Cell(int x, int y, Island island) {
        this.x = x;
        this.y = y;
        this.island = island;
        Random r = new Random();
        this.plantAmount = r.nextInt(200);

    }

    public void populate() {
        Random r = new Random();
        if (r.nextInt(10) == 1)
            AnimalFactory.create("Wolf", x, y, island);
        if (r.nextInt(100) < 30)
            AnimalFactory.create("Rabbit", x, y, island);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
