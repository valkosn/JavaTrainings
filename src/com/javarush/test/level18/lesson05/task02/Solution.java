package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFilePath = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(inFilePath);
        List<Integer> data = new ArrayList<>();
        int countSymbols = 0;

        while (inputStream.available() > 0) {
            data.add(inputStream.read());
        }
        inputStream.close();

        for(Integer x : data) {
            if (x == 44) countSymbols++;
        }
        System.out.println(countSymbols);





    }
}
