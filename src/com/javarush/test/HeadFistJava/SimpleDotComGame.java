/*
 * Copyright (c) 2016.
 */

package com.javarush.test.HeadFistJava;

/**
 * Created by Valko Serhii on 17.02.2016.
 */
public class SimpleDotComGame
{
    public static void main(String[] args)
    {
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();
        SimleDotCom theDotCom = new SimleDotCom();
        int randomNum = (int) (Math.random() * 5);
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        theDotCom.setLocationCells(locations);
        boolean isAlive = true;

        while (isAlive)
        {
            String guess = helper.getUserInput("Введите число");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("Потопил"))
            {
                isAlive = false;
                System.out.println("Вам потребовалось " + numOfGuesses + " попыток(и)");
            }

        }
    }
}
