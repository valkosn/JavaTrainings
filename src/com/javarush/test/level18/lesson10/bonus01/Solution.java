package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные

"-e E:\Work\Test\Test.txt E:\Work\Test\enc.txt"
"-d E:\Work\Test\enc.txt E:\Work\Test\dec.txt"
*/


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//TODO:done
public class Solution
{
    public static void main(String[] args) throws IOException
    {

        final int startArg = 0;
        final int idxKey = 0;
        final int idxInFile = 1;
        final int idxOutFile = 2;
        final int cryptKey = 2;
        int action = 0;

        String key = args[startArg].split(" ")[idxKey];
        String fileInName = args[startArg].split(" ")[idxInFile];
        String fileOutName = args[startArg].split(" ")[idxOutFile];

        if (key.equals("-e")) action = cryptKey;
        else if (key.equals("-d")) action = -cryptKey;
        else System.out.println("Bad argument!");

        FileInputStream inputStream = new FileInputStream(fileInName);
        FileOutputStream outputStream = new FileOutputStream(fileOutName);
        while (inputStream.available() > 0)
        {
            int encByte = inputStream.read() + action;
            outputStream.write(encByte);
        }
        inputStream.close();
        outputStream.close();

    }

}
