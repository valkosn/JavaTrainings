package com.javarush.test.level08.lesson11.home09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {

        String date = "MAY 1 2013";

        try
        {
            System.out.println(new SimpleDateFormat("MMMM d yyyy").parse(date));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }




    }

    public static boolean isDateOdd(String date)
    {
        try
        {
            Date startDate = new SimpleDateFormat("MMM d yyyy").parse(date);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }


        Calendar endDate = Calendar.getInstance();
        endDate.set(Calendar.MONTH, Calendar.JANUARY);
        endDate.set(Calendar.DATE, 1);
        endDate.set(Calendar.HOUR, 0);
        endDate.set(Calendar.MINUTE, 0);
        endDate.set(Calendar.SECOND, 0);
        endDate.set(Calendar.MILLISECOND, 0);


        return true;
    }
}
