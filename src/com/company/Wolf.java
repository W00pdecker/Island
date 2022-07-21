package com.company;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Wolf extends Carnivore {

    public int health = 3;
    public static AtomicInteger count = new AtomicInteger(0); //счетчик созданных волков
    private  double weight = 50.0;
    public  int maxAmount = 30;
    public  AtomicInteger actualAmount = new AtomicInteger(0);
    private  int speed = 3;
    private  double satiety = 8;
    public  String className = "Wolf";
    public  HashMap<String, Integer> prey = new HashMap<>(){{
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
        this.speed = 5;
        //Wolf.actualAmount.getAndIncrement();
        island.cells[x][y].wolves.add(this);
        island.animals.add(this);
    }

    @Override
    public void move() {
        synchronized (Island.cells[x][y].wolves) {
            Island.cells[x][y].wolves.remove(this);
        }
        super.move();
        synchronized (Island.cells[x][y].wolves) {
            Island.cells[x][y].wolves.add(this);
        }
    }

    @Override
    public void die() {
        super.die();
        synchronized (Island.cells[x][y].wolves) {
            Island.cells[x][y].wolves.remove(this);
        }
    }
}
