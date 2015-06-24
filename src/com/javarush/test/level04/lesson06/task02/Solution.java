package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
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

        String ns3 = null;
        try {
            ns3 = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String ns4 = null;
        try {
            ns4 = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int n1=Integer.parseInt(ns1);
        int n2=Integer.parseInt(ns2);
        int n3=Integer.parseInt(ns3);
        int n4=Integer.parseInt(ns4);

        if (n1>n2&n1>n3&n1>n4)
            System.out.print(n1);
            else
                if(n2>n3&n2>n4)
                    System.out.print(n2);
            else
                    if(n3>n4)
                        System.out.print(n3);
        else
                        System.out.print(n4);

    }



    }
