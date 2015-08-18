package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Ra1004ek on 18.08.2015.
 */
public class RussianHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 32;
    }

    @Override
    String getDescription()
    {
        return (super.getDescription() + " Моя страна - "+Country.RUSSIA+ ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}

