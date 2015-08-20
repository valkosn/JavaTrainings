package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Ra1004ek on 20.08.2015.
 */
public class Plane implements Flyable
{
    private int countPassengers;

    public Plane(int countPassengers){
        this.countPassengers = countPassengers;
    }
    @Override
    public void fly()
    {

    }
}
