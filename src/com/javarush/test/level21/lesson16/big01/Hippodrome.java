/*
 * Copyright (c) 2015.
 */

package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Ra1004ek on 14.09.2015.
 */
//TODO:in progress
public class Hippodrome
{
    static ArrayList<Horse> horses = new ArrayList<>();

    public static Hippodrome game;

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws Exception {

        for (int i = 1; i <= 100; i++)
        {
            move();
            print();
            Thread.sleep(500);
        }

    }

    public void print() {

        for (Horse horse : horses) {
            horse.print();
            System.out.println();
            System.out.println();
        }


    }

    public void move() {

        for (Horse horse : horses) {
            horse.move();
        }

    }


    public static void main(String[] args) throws Exception
    {
       game = new Hippodrome();
        Horse horse1 = new Horse("Vulkan", 3, 0);
        Horse horse2 = new Horse("Parkan", 3, 0);
        Horse horse3 = new Horse("Olen", 3, 0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        game.run();


    }
}
