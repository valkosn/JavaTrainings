package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Ra1004ek on 19.08.2015.
 */
public class Earth implements Planet
{
    private static Earth ourInstance = new Earth();

    public static Earth getInstance()
    {
        return ourInstance;
    }

    private Earth()
    {
    }
}
