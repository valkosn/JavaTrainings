package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFile = reader.readLine();
        String outFile = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(inFile));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outFile));


        while (fileReader.ready())
        {

            String string = fileReader.readLine().replace('.', '!');
            fileWriter.write(string);


        }

        fileReader.close();
        fileWriter.close();
    }
}
