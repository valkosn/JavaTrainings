package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathFile1 = reader.readLine();
        String pathFile2 = reader.readLine();
        reader.close();

        FileInputStream in1 = new FileInputStream(pathFile1);
        byte [] dataOfFile = new byte [in1.available()];
        int count = 0;

        while (in1.available() > 0) {
            dataOfFile[count] = (byte)in1.read();
            count++;
        }
        in1.close();


        FileOutputStream outStrem = new FileOutputStream(pathFile1);
        FileInputStream inputStream = new FileInputStream(pathFile2);

        while (inputStream.available() > 0) {
            outStrem.write(inputStream.read());
        }
        inputStream.close();

        outStrem.write(dataOfFile);
        outStrem.close();


    }
}
