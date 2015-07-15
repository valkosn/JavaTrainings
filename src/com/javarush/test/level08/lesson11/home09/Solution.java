package com.javarush.test.level08.lesson11.home09;

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


        Date date1 = new Date(convertedInputDate);
        Date date2 = new Date();
        date2.setYear(date1.getYear());
        date2.setMonth(0);
        date2.setDate(1);
        long msTimeDistance = date1.getTime() - date2.getTime();
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках

        int dayCount = (int) (msTimeDistance / msDay);

//        System.out.println(date1);
//        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.ENGLISH);
//        LocalDate endDate = LocalDate.parse(convertedInputDate, formatDate);
//        LocalDate startDate = LocalDate.of(endDate.getYear(), 1, 1);
//        long diff = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        //System.out.print(convertedInputDate.toUpperCase() + " = ");
        return dayCount % 2 != 0;

    }


}
