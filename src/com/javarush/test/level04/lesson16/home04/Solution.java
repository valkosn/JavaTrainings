package com.javarush.test.level04.lesson16.home04;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
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
        try
        {
            ns1 = bufferedReader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String ns4 = null;
        try
        {
            ns4 = bufferedReader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String ns3 = null;
        try
        {
            ns3 = bufferedReader.readLine();
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



        int n1 = Integer.parseInt(ns2);
        int n2 = Integer.parseInt(ns3);
        int n3 = Integer.parseInt(ns4);


        System.out.println("Меня зовут " + ns1);
        System.out.println("Я родился "+n1+"."+n2+"."+n3);
    }
}
