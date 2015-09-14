/*
 * Copyright (c) 2015.
 */

package com.javarush.test.level23.lesson13.big01;

import java.util.ArrayList;

/**
 * Created by Ra1004ek on 15.09.2015.
 */
public class Snake
{
    ArrayList<SnakeSection> sections = new ArrayList<>();
    boolean isAlive;
    SnakeDirection direction;

    public void setDirection(SnakeDirection direction)
    {
        this.direction = direction;
    }

    public ArrayList<SnakeSection> getSections()
    {

        return sections;
    }

    public boolean isAlive()
    {
        return isAlive;
    }

    public SnakeDirection getDirection()
    {
        return direction;
    }
}
