package com.company;

import java.util.Arrays;
import java.util.List;

public class Statistics {

    Island island;
    List<Cell> cells = Arrays.stream(island.cells).flatMap(x -> Arrays.stream(x)).toList();

    public Statistics(Island island) {
        this.island = island;
    }

    public long countAll() {
        return island.animals.size();
    }


    public long countWolves() {
        long wolfsAmount = cells.stream().flatMap(cell -> cell.wolves.stream()).count();
        return wolfsAmount;
    }


    public long countRabbits() {
        long rabbitsAmount = cells.stream().flatMap(cell -> cell.rabbits.stream()).count();
        return rabbitsAmount;

    }
}
