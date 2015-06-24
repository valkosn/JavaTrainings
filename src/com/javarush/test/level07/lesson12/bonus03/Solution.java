package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(int[] array)
    {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        //int[] result = new int[20];

        for (int x : array)
        {
            temp.add(x);
        }

        for (int i = 0; i < 20; i++)
        {
            array[i] = Collections.max(temp);
            temp.remove(Collections.max(temp));
        }
                 //напишите тут ваш код
    }
}
