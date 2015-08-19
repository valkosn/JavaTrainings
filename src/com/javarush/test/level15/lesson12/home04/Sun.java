package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Ra1004ek on 19.08.2015.
 */
public class Sun implements Planet
{
    private static Sun ourInstance = new Sun();

    public static Sun getInstance()
    {
        return ourInstance;
    }

    private Sun()
    {
    }
}
