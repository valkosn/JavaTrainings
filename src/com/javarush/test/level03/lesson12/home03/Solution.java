package com.javarush.test.level03.lesson12.home03;

/* Я буду зарабатывать $50 в час
Ввести с клавиатуры число n.
Вывести на экран надпись «Я буду зарабатывать $n в час».
Пример:
Я буду зарабатывать $50 в час
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String age = null;
        try {
            age = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int nAge=Integer.parseInt(age);
        System.out.print("Я буду зарабатывать $"+nAge+" в час");
    }
}