package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFile = reader.readLine();
        String outFile = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(inFile));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outFile));


        while (fileReader.ready())
        {

            String string = fileReader.readLine();
            String[] arrString = string.split(" ");


            for (String x : arrString)
            {
                try
                {
                    fileWriter.write(Integer.parseInt(x) + " ");

                }
                catch (NumberFormatException ignore)
                {
                    /*NOP*/
                }
            }
        }

        fileReader.close();
        fileWriter.close();

    }
}
