package com.company;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Wolf extends Carnivore {

    public int health = 3;
    public static AtomicInteger count = new AtomicInteger(0); //счетчик созданных волков
    private static double weight = 50.0;
    public static int maxAmount = 30;
    public static AtomicInteger actualAmount = new AtomicInteger(0);
    private static int speed = 3;
    private static double satiety = 8;
    public static String className = "Wolf";
    public static HashMap<String, Integer> prey = new HashMap<>(){{
            put("Rabbit", 60);
            put("Deer", 30);
        }};



    public Wolf(int x, int y, String ID, Island island) {
        this.x = x;
        this.y = y;
        this.island = island;
        this.ID = ID;
        this.isMale = ThreadLocalRandom.current().nextBoolean();
        this.name = name;
        Wolf.actualAmount.getAndIncrement();
        island.cells[x][y].wolves.add(this);
        island.animals.add(this);
    }

    @Override
    public void move() {
        island.cells[x][y].wolves.remove(this);
        super.move();
        island.cells[x][y].wolves.add(this);
    }

}
