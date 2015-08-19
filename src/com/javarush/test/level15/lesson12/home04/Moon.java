package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Ra1004ek on 19.08.2015.
 */
public class Moon implements Planet
{
    private static Moon ourInstance = new Moon();

    public static Moon getInstance()
    {
        return ourInstance;
    }

    private Moon()
    {
    }
}
