package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

public class Game extends  Thread {
    public static Island island;
    public static Statistics stat;
    public int days = 0;



    public Game(Island island) {
        this.island = island;
    }



    @Override
    public void run() {
        System.out.println("Game start");
        stat = new Statistics();
        List<Cell> cells = Arrays.stream(Island.cells).flatMap(x -> Arrays.stream(x)).toList();
        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(4);
        List<Animal> workers = Island.animals.stream().toList();
        mainPool.scheduleWithFixedDelay(() -> {
            System.out.println("day start");
            ExecutorService servicePool;
            servicePool = Executors.newFixedThreadPool(20);
            workers.forEach(servicePool::submit);
            System.out.println("All animals done");

            servicePool.shutdown();
            //cells.forEach(Cell::plantGrow);
            showStatistics();
            System.out.println(Island.animals.stream().count());
            if (++days > 10) {
               mainPool.shutdownNow();
            }
        },1000, 1000, TimeUnit.MILLISECONDS);
    }

    public void showStatistics() {
        System.out.println("started statistics");
       System.out.println("Days: " + days);
       System.out.println("    Animals on map: " + stat.countAll());
       System.out.println("    Wolfs: " + stat.countWolves() + "   Rabbits: " + stat.countRabbits());
        System.out.println(    "Plants: " + stat.countPlants());
    }
}
