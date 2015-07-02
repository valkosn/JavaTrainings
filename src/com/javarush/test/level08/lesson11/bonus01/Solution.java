package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();

        SimpleDateFormat format = new SimpleDateFormat("MMMM", Locale.US);
        Date monthDate = null;
        try
        {
            monthDate = format.parse(month);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        int monthDatePrint = monthDate.getMonth() +1;
        System.out.println(month + " is " + monthDatePrint + " month");
        //напишите тут ваш код
    }

}
