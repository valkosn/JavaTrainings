/*
 * Copyright (c) 2016.
 */

package com.javarush.test.HeadFistJava;

/**
 * Created by Valko Serhii on 17.02.2016.
 */
public class SimleDotCom
{
    int[] locationCells;
    int numOfHits = 0;

    public void setLocationCells(int[] locs)
    {
        locationCells = locs;
    }

    public String checkYourself(String stringGuess)
    {
        int guess = Integer.parseInt(stringGuess);
        String result = "Мимо";
        for (int cell : locationCells)
        {
            if (guess == cell)
            {
                result = "Попал";
                numOfHits++;
                break;
            }
        }

        if (numOfHits == locationCells.length)
        {
            result = "Потопил";
        }
        System.out.println(result);
        return result;
    }

}
