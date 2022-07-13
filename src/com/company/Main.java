package com.company;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {

    public static void main(String[] args) {




        Island island = new Island(10, 10);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(16);

        class TimeLine implements Runnable {

            public void run() {
                emulateThreadFactory();
            }

        }

        ThreadGroup animals = new ThreadGroup("Animals");


    }
}
