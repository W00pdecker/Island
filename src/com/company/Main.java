package com.company;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {

    public static void main(String[] args) {
        System.out.println("main start");
        Island island = new Island(20, 20);
        AnimalFactory factory = new AnimalFactory();
        System.out.println(island.cells.length);
        Game game = new Game(island);
        game.start();

    }
}
