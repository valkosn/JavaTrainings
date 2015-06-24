package com.javarush.test.level04.lesson16.home03;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int sum = 0;
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

            int n1 = Integer.parseInt(ns1);


            sum+=n1;
            if (n1==-1)
            {
                System.out.println(sum);
                return;
            }

        }

    }
}
