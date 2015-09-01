package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathFile1 = reader.readLine();
        String pathFile2 = reader.readLine();
        String pathFile3 = reader.readLine();
        reader.close();

        FileOutputStream stream1 = new FileOutputStream(pathFile1);
        FileInputStream stream2 = new FileInputStream(pathFile2);
        FileInputStream stream3 = new FileInputStream(pathFile3);

        while(stream2.available() > 0) {

            int data = stream2.read();
            stream1.write(data);
        }
        stream2.close();

        while (stream3.available() > 0) {

            int data = stream3.read();
            stream1.write(data);
        }
        stream1.close();
        stream3.close();

    }
}
