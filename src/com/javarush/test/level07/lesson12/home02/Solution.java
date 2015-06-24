package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(reader.readLine());
        Integer M = Integer.parseInt(reader.readLine());

        ArrayList<String> strings = new ArrayList<String>();

        for (int i = 0; i < N; i++)
        {
            strings.add(reader.readLine());
        }

        for (int i = 0; i < M; i++)
        {
            String s = strings.get(0);
            strings.remove(0);
            strings.add(s);

        }

        for (String x : strings) {
            System.out.println(x);
        }

        //напишите тут ваш код

    }
}
