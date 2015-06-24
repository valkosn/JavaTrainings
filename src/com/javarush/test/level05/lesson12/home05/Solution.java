package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import org.omg.PortableInterceptor.ServerRequestInfo;

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int sum = 0;
        String exitPoint = "сумма";
        Boolean ex = true;
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (ex)
        {
            String ns1 = null;
            try
            {
                ns1 = bufferedReader.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }


            if (ns1.equals(exitPoint))
            {
                System.out.println(sum);
                return;
            }
            int n1 = Integer.parseInt(ns1);
            sum+=n1;

        }
    }
}
