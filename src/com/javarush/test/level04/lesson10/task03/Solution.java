package com.javarush.test.level04.lesson10.task03;

import java.io.*;

/* Хорошего не бывает много
Ввести с клавиатуры строку и число N.
Вывести на экран строку N раз используя цикл while.
Пример ввода:
абв
2
Пример вывода:
абв
абв
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int i =1;
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String ns1 = null;
        try
        {
            ns1 = bufferedReader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String ns2 = null;
        try
        {
            ns2 = bufferedReader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        int n2 = Integer.parseInt(ns2);

        while(i<=n2)
        {
            System.out.println(ns1);
            i++;
        }

    }
}
