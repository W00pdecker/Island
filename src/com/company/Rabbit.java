package com.company;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Rabbit extends  Herbivore {
    public int health = 1;
    public static AtomicInteger count = new AtomicInteger(0); //счетчик созданных кроликов
    private static double weight = 2.0;
    public static int maxAmount = 150;
    public static AtomicInteger actualAmount = new AtomicInteger(0);
    private static int speed = 2;
    private static double satiety = 0.45;
    public static String className = "Rabbit";

    public Rabbit(int x, int y, String ID, Island island) {
        this.x = x;
        this.y = y;
        this.ID = ID;
        this.island = island;
        this.isMale = ThreadLocalRandom.current().nextBoolean();
        this.name = name;
        Rabbit.actualAmount.getAndIncrement();
        island.cells[x][y].rabbits.add(this);
        island.animals.add(this);
    }

    @Override
    public void move() {
        island.cells[x][y].rabbits.remove(this);
        super.move();
        island.cells[x][y].rabbits.add(this);
    }



}
