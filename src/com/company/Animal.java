package com.company;

public abstract class Animal {
    private double weigth;
    private int amount;
    private int speed;
    private double hunger;

    public abstract void eat();

    public void reproduce() {

    }

    public void choosePath() {

    }

    public void die() {

    }

    public double getWeigth() {
        return weigth;
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
