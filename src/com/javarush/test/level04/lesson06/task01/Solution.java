package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String ns1 = null;
        try {
            ns1 = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String ns2 = null;
        try {
            ns2 = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int n1=Integer.parseInt(ns1);
        int n2=Integer.parseInt(ns2);
        if (n1<n2)
            System.out.print(n1);
                       else //Напишите тут ваш код
        System.out.print(n2);
        /* данные для тестирования:
        введите 1 и 2, минимум =  1
        введите 2 и 1, минимум =  1
        введите 1 и 1, минимум =  1
        введите -1 и -2, минимум =  -2
         */
    }
}