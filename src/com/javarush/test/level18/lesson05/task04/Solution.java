package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFilePath = reader.readLine();
        String outFilePath = reader.readLine();
        reader.close();

        List<Integer> data = new LinkedList<>();
        FileInputStream inputStream = new FileInputStream(inFilePath);
        FileOutputStream outputStream = new FileOutputStream(outFilePath);

        while (inputStream.available() > 0) {
            data.add(inputStream.read());
        }

        Collections.reverse(data);

        for(Integer x : data) {
            outputStream.write(x);
        }

        inputStream.close();
        outputStream.close();

    }
}
