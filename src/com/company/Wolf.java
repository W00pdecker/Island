package com.company;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Wolf extends Carnivore {

    public int health = 3;
    public static AtomicInteger count = new AtomicInteger(0);
    private static double weight = 50.0;
    public static int maxAmount = 30;
    public static AtomicInteger actualAmount = new AtomicInteger(0);
    private static int speed = 3;
    private static double satiety = 8;
    public static String className = "Wolf";


    public Wolf(int x, int y, String name, Island island) {
        this.x = x;
        this.y = y;
        this.island = island;
        this.isMale = ThreadLocalRandom.current().nextBoolean();
        this.name = name;
        Wolf.actualAmount.getAndIncrement();
        prey.put("Rabbit", Integer.valueOf(60));
    }

    @Override
    public void move() {
        island.cells[x][y].wolves.remove(this);
        super.move();
        island.cells[x][y].wolves.add(this);
    }

    @Override
    public void eat() {

    }

    @Override
    public boolean hunt() {
        return super.hunt();
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }

    @Override
    public void die() {
        super.die();
    }


}
