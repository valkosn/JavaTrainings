package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Ra1004ek on 18.08.2015.
 */
public  class Singleton
{
    private Singleton()
    {

    }

    private static final Singleton SINGLETON = new Singleton();


    static Singleton getInstance()
    {
        return SINGLETON;
    }

}

