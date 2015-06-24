package com.javarush.test.level04.lesson06.task05;

/* 18+
Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще».
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


        int n2=Integer.parseInt(ns2);

        if (n2<18)
            System.out.print("Подрасти еще");
    }
}
