package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Ra1004ek on 18.08.2015.
 */
public class MoldovanHen extends Hen
{
    @Override
    int getCountOfEggsPerMonth()
    {
        return 1;
    }

    @Override
    String getDescription()
    {
        return (super.getDescription() + " Моя страна - "+Country.MOLDOVA+ ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.");
    }
}
