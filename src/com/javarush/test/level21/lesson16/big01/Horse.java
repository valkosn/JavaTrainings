/*
 * Copyright (c) 2015.
 */

package com.javarush.test.level21.lesson16.big01;

/**
 * Created by Ra1004ek on 14.09.2015.
 */
public class Horse
{
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public void move() {

        distance += Math.random() * speed;

    }

    public void print() {

        for (int i = 0; i < Math.round(getDistance()); i++)
        {
            System.out.print(".");
        }
        System.out.println(getName());

    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }
}
