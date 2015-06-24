package com.javarush.test.level04.lesson13.task02;

import java.io.*;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

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


        int m = Integer.parseInt(ns1);
        int n = Integer.parseInt(ns2);

        for (int j = 0; j != m; j++)
        {
            for (int i = 0; i != n; i++)
                System.out.print("8");

            System.out.println("");
        }

    }


}
