package com.company.Animals;

import com.company.Animal;
import com.company.AnimalFactory;
import com.company.Carnivore;
import com.company.Island;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Wolf extends Animal implements Carnivore {
    public static AtomicInteger count = new AtomicInteger(0);
    private static double weight = 50.0;
    private static int amount = 30.0;
    private static int speed = 3;
    private static double hunger = 8;


    public Wolf(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.isMale = ThreadLocalRandom.current().nextBoolean();
        this.name = name;
    }

    @Override
    public void eat(Animal animal) {

    }

    @Override
    public void move(Island island) {
        island.cells[x][y].wolves.remove(this);
        super.move(island);
        island.cells[x][y].wolves.add(this);
    }

    @Override
    public void reproduce(Island island) {
        if (!this.isPregnant) {
            for (Wolf wolf : island.cells[x][y].wolves) {
                if (wolf.isMale != this.isMale && !wolf.isPregnant) {

                    if (!this.isMale)
                        this.isPregnant = true;
                    else
                        wolf.isPregnant = true;
                    break;
                }
            }
        }
        else if (pregnantCount == 5) {
            AnimalFactory.create(Wolf, x, y);
            pregnantCount = 0;
            isPregnant = false;
        }
        else pregnantCount++;

    }
}
