package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
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

        String ns2 = null;
        try
        {
            ns2 = bufferedReader.readLine();
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

        int n1 = Integer.parseInt(ns1);
        int n2 = Integer.parseInt(ns2);
        int n3 = Integer.parseInt(ns3);

        if (n1 > n2 & n1 < n3)
            System.out.print(n1);
        if (n1 < n2 & n1 > n3)
            System.out.print(n1);
        if (n2 > n1 & n2 < n3)
            System.out.print(n2);
        if (n2 < n1 & n2 > n3)
            System.out.print(n2);
        if (n3 > n1 & n3 < n2)
            System.out.print(n3);
        if (n2 < n1 & n3 > n2)
            System.out.print(n3);
    }
}
