package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double doubleData = 0;


        while (true)
        {
            String tempData = reader.readLine();

            if ("exit".equals(tempData)) break;

            try
            {
                doubleData = Double.parseDouble(tempData);
                if (doubleData % (int) doubleData != 0) print(doubleData);
                else if (doubleData != 0 && doubleData > 0 && doubleData < 128)
                {
                    print((short) doubleData);
                } else if (doubleData != 0 && doubleData >= 128)
                {
                    print((int) doubleData);
                }
            }
            catch (NumberFormatException e)
            {
                print(tempData);
            }


        }

        //напиште тут ваш код
    }

    public static void print(Double value)
    {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value)
    {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value)
    {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value)
    {
        System.out.println("Это тип Integer, значение " + value);
    }
}
