package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class Island {
    public final int HEIGHT;
    public final int WIDTH;

    public Cell[][] cells;
    public HashSet<Animal> animals = new HashSet<>();

    public Island(int height, int width) {
        this.HEIGHT = height;
        this.WIDTH = width;
        this.cells = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                cells[i][j] = new Cell(i, j, this);
                cells[i][j].populate();
            }
        }

        System.out.println("Island ready");
    }

    public int getHeight() {
        return HEIGHT;
    }

    public int getWidth() {
        return WIDTH;
    }


}
