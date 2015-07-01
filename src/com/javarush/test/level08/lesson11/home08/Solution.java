package com.javarush.test.level08.lesson11.home08;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.collections.transformation.SortedList;

import javax.lang.model.type.ArrayType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array)
    {
        //TODO:Test not successful;


        Set<Integer> firstTemp = new HashSet<>();
        ArrayList<Integer> secondTemp = new ArrayList<>();

        for (int i = 0; i < array.length; i++)
        {
            firstTemp.add(array[i]);
            array[i] =0;
        }

        secondTemp.addAll(firstTemp);
        Collections.sort(secondTemp);
        Collections.reverse(secondTemp);

        for (int i = 0; i < secondTemp.size(); i++)
        {
            array[i] = secondTemp.get(i);
        }
        //напишите тут ваш код
    }
}
