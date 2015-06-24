package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны». Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String n1 = null;
        try {
            n1 = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String n2 = null;
        try {
            n2 = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


         if (n1.equals(n2))
            System.out.print("Имена идентичны");
        else
             if (n1.length()==n2.length())
             {
                 System.out.print("Длины имен равны");
             }
    }
}
