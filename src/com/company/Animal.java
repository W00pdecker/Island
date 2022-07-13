package com.company;

import java.util.concurrent.ThreadLocalRandom;

import static com.company.Direction.*;

public abstract class Animal implements Runnable{
    private double weight;
    private int amount;
    private int speed;
    private double hunger;
    public int x;
    public int y;

    public String name;
    public boolean isMale;
    public boolean isPregnant = false;
    public int pregnantCount = 0;




    public void run() {


    }


    public abstract void reproduce(Island island);

    public void move(Island island){ //двигаемся по острову, если упираемся в границу, меняем направление
        int action = speed;
        Direction direction = choosePath();
        while (action > 0) {
            if (direction == UP) {
                if (y > 0) {
                    y--;
                    action--;
                }
                else direction = choosePath();
            }
            else if (direction == DOWN) {
                if (y < (island.HEIGHT - 1)) {
                    y++;
                    action--;
                }
                else direction = choosePath();
            }
            else if (direction == LEFT) {
                if (x > 0) {
                    x--;
                    action--;
                }
                else direction = choosePath();
            }
            else if (direction == RIGHT) {
                if (x < (island.WIDTH - 1)) {
                    x++;
                    action--;
                }
                else direction = choosePath();
            }
        }

    }

    public Direction choosePath() { //метод, который случайным образом выбирает направление
        int direction = ThreadLocalRandom.current().nextInt(3);
        return switch (direction) {
            case 0:
                yield UP;
            case 1:
                yield LEFT;
            case 2:
                yield DOWN;
            case 3:
                yield RIGHT;
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        };
    }


    public void die() {

    }



    public double getWeight() {
        return weight;
    }

    public int getAmount() {
        return amount;
    }

    public int getSpeed() {
        return speed;
    }

    public double getHunger() {
        return hunger;
    }
}
