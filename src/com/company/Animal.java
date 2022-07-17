package com.company;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static com.company.Direction.*;

public abstract class Animal implements Runnable{

    public int health;
    public double weight;
    private int maxAmount;
    private int speed;
    public String className;
    public int reproduceRate;
    public static AtomicInteger actualAmount;

    public int x;   //координаты животного
    public int y;
    public String name; // имя животного
    public boolean isMale; // пол животного
    public boolean isPregnant = false;  // флаг "(не)беременный"
    public int pregnantCount = 0;  // счетчик дней беременности
    public boolean isDead = false; // флаг "мертвый/живой"
    public Island island;
    public double satiety;
    public int starvingCount = 0;



    public void run() {
        while (!isDead) {
            move();
            eat();
            reproduce();
        }
    }

    public abstract void eat();

    public void reproduce() {
        if (!isPregnant) {
            for (Animal animal : island.cells[x][y].residents.get(className)) {
                if (animal.isMale != isMale && !animal.isPregnant) {

                    if (!isMale)
                        isPregnant = true;
                    else
                        animal.isPregnant = true;
                    break;
                }
            }
        }
        else if (pregnantCount == reproduceRate) {
            if (actualAmount.get() < maxAmount) {
                AnimalFactory.create(className, x, y, island);
            }
            pregnantCount = 0;
            isPregnant = false;

        }
        else pregnantCount++;

    }

    public void move(){ //двигаемся по острову, если упираемся в границу, меняем направление
        int movePoints = speed;
        Direction direction = choosePath();
        while (movePoints > 0) {
            if (direction == UP) {
                if (y > 0) {
                    y--;
                    movePoints--;
                }
                else direction = choosePath();
            }
            else if (direction == DOWN) {
                if (y < (island.HEIGHT - 1)) {
                    y++;
                    movePoints--;
                }
                else direction = choosePath();
            }
            else if (direction == LEFT) {
                if (x > 0) {
                    x--;
                    movePoints--;
                }
                else direction = choosePath();
            }
            else if (direction == RIGHT) {
                if (x < (island.WIDTH - 1)) {
                    x++;
                    movePoints--;
                }
                else direction = choosePath();
            }
        }

    }

    public Direction choosePath() {                 //метод, который случайным образом выбирает направление
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
        isDead = true;
        actualAmount.getAndDecrement();
    }
}
