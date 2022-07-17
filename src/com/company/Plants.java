package com.company;

public class Plants implements Runnable {

    public  Island island;
    @Override
    public void run() {
        for (Cell[] row : island.cells) {
            for (Cell cell : row) {
                cell.plantAmount += 50;
            }
        }
    }


}
