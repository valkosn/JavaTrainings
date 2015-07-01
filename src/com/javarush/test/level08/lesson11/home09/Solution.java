package com.javarush.test.level08.lesson11.home09;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

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
        System.out.println(isDateOdd("JANUARY 1 2000"));
        System.out.println(isDateOdd("JANUARY 2 2020"));
        System.out.println(isDateOdd("DeCemBer 12 2020"));
        System.out.println(isDateOdd("oCTOBER 8 2020"));
    }

    public static boolean isDateOdd(String date)
    {
        date = date.toLowerCase();
        char[] inputDateChars = date.toCharArray();

        boolean upper = true;
        for (int i = 0; i < inputDateChars.length; i++)
        {
            char space = ' ';
            if (inputDateChars[i] == space)
            {
                upper = true;
            } else if (upper)
            {
                inputDateChars[i] = Character.toUpperCase(inputDateChars[i]);
                upper = false;
            }
        }
        String convertedInputDate = "";

        for (char inputDateChar : inputDateChars)
        {
            convertedInputDate += Character.toString(inputDateChar);
        }


        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);
        LocalDate endDate = LocalDate.parse(convertedInputDate, formatDate);
        LocalDate startDate = LocalDate.of(endDate.getYear(), 1, 1);
        long diff = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        System.out.print(convertedInputDate.toUpperCase() + " = ");
        return diff % 2 != 0;

    }


}
