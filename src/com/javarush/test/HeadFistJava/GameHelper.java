/*
 * Copyright (c) 2016.
 */

package com.javarush.test.HeadFistJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Valko Serhii on 17.02.2016.
 */
public class GameHelper
{
    public String getUserInput(String promt)
    {
        String inputLine = null;
        System.out.print(promt + " ");
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            inputLine = reader.readLine();
            if (inputLine == null) return null;
        }
        catch (IOException e)
        {
            System.out.println("IOException" + e);
        }
        return inputLine;
    }
}
