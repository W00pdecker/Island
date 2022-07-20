package com.company;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Game extends  Thread {
    public Island island;
    public int days = 0;

    public Game(Island island) {
        this.island = island;
    }



    @Override
    public void run() {
        System.out.println("Game start");
        ScheduledExecutorService mainPool = Executors.newScheduledThreadPool(4);
        List<Animal> workers = island.animals.stream().toList();
        mainPool.scheduleWithFixedDelay(() -> {
            System.out.println("day start");
            ExecutorService servicePool;
            servicePool = Executors.newFixedThreadPool(20);
            workers.forEach(servicePool::submit);
            System.out.println("All animals done");
            servicePool.shutdown();
            //showStatistics();
            //if (++days > 10) {
            //    mainPool.shutdownNow();
            //}
        },1000, 1000, TimeUnit.MILLISECONDS);
    }

    public void showStatistics() {
        Statistics stat = new Statistics(island);
        System.out.println("Days: " + days);
        System.out.println("    Animals on map: " + stat.countAll());
        System.out.println("    Wolfs: " + stat.countWolves() + "   Rabbits: " + stat.countRabbits());
    }
}
