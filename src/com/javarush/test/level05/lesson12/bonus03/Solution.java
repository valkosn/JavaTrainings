package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        if (n > 0)
        {
            int num;
            int maximum = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n-1; i++)
            {
                num = Integer.parseInt(reader.readLine());

                if (maximum < num) maximum = num;
            }

            System.out.println(maximum);
        } else
            System.out.println("Какашка");


    }

}
