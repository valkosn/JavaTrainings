package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFile= reader.readLine();
        String outFile = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(inFile);
        FileOutputStream outputStream = new FileOutputStream(outFile);
        int check = 1;

        while (inputStream.available() > 0){

            int data = inputStream.read();
            if (check%2 == 0) outputStream.write(data);
            check++;
        }

        inputStream.close();
        outputStream.close();
    }
}
