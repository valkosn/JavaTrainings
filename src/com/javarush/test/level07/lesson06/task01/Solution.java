package com.javarush.test.level07.lesson06.task01;

/* 5 различных строчек в списке
1. Создай список строк.
2. Добавь в него 5 различных строчек.
3. Выведи его размер на экран.
4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> strings = new ArrayList<String>();

        strings.add("Kaka");
        strings.add("Syka");
        strings.add("Paka");
        strings.add("Muka");
        strings.add("Zaka");



        System.out.println(strings.size());

        for (int i = 0; i < 5; i++)
        {
            System.out.println(strings.get(i));
        }
    }
}
