package com.company;

import java.util.Random;

public class Cell {
    private int x;
    private int y;
    public int plantAmount;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        plantAmount = Random.nextInt(5);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
