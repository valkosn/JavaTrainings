package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathFile = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(pathFile);
        int minByte = Integer.MAX_VALUE;
        while (inputStream.available() > 0)
        {
            int currByte = inputStream.read();
            minByte = minByte < currByte ? minByte : currByte;
        }
        inputStream.close();
        System.out.println(minByte);
    }
}
