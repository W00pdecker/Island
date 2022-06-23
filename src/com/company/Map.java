package com.company;

public class Map {
    private final int height;
    private final int width;

    public Cell[][] cells;

    public Map(int height, int width) {
        this.height = height;
        this.width = width;
        this.cells = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


}
