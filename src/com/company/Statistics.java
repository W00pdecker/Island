package com.company;

import java.util.Arrays;
import java.util.List;

public class Statistics {

    public List<Cell> cells = Arrays.stream(Island.cells).flatMap(x -> Arrays.stream(x)).toList();

    public Statistics() {
    }

    public long countAll() {
        return Island.animals.size();
    }


    public long countWolves() {
        long wolfsAmount = cells.stream().flatMap(cell -> cell.wolves.stream()).count();
        return wolfsAmount;
    }


    public long countRabbits() {
        long rabbitsAmount = cells.stream().flatMap(cell -> cell.rabbits.stream()).count();
        return rabbitsAmount;

    }

    public Integer countPlants() {
        Integer plantsAmount = cells.stream().map(cell -> cell.plantAmount).reduce(0, Integer::sum);
        return plantsAmount;
    }
}
