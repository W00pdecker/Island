package com.company;

public class Herbivore extends Animal {

    @Override
    public void eat() {
        starvingCount = (graze()) ? 0 : starvingCount + 1; // если охота прошла успешно, то счетчик голода обнуляется, иначе - растет
        if (starvingCount == health)
            die();
    }

    public boolean graze() {
        double hunger = satiety;
        int food = island.cells[x][y].plantAmount;
        if (food >= hunger) {
            island.cells[x][y].plantAmount -= hunger;
            return true;
        }
        else {
            island.cells[x][y].plantAmount = 0;
            return false;
        }
    }
}