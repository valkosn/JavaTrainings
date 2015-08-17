package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String outPath = bufferedReader.readLine();

        OutputStream outputStream = new FileOutputStream(outPath);

        while (true)
        {
            String inData = bufferedReader.readLine();
            String fInData = inData + "\n";
            outputStream.write(fInData.getBytes());


            if (inData.equals("exit")) break;
        }
    }
}
