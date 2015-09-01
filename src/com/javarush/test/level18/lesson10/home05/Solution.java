package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathFile1 = reader.readLine();
        String pathFile2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(pathFile1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(pathFile2));

        while (fileReader.ready())
        {

            String dataString = fileReader.readLine();
            String[] dataArrayString = dataString.split(" ");



            for (String elem : dataArrayString)
            {
                String result = Math.round(Float.parseFloat(elem)) + " ";

                fileWriter.write(result);
            }

        }

        fileReader.close();
        fileWriter.close();


    }
}
