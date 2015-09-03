package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        int count = 0;

        while (fileReader.ready()) {

            String data = fileReader.readLine();

            String replacedString = data.replaceAll("\\p{P}"," ").toLowerCase();
            replacedString=replacedString.replaceAll("\\s"," ");

            String [] arrData = replacedString.split(" ");

            for (String elem : arrData) {
                if ("world".equals(elem)) count++;
            }

        }
        fileReader.close();
        System.out.println(count);
    }
}
