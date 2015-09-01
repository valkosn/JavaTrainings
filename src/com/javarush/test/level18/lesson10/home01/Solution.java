package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream inputStream = new FileInputStream(args[0]);
        int engLitCount = 0;

        while (inputStream.available() > 0)
        {
            int currByte = inputStream.read();
            if ((currByte >= 65 && currByte <= 90) || (currByte >= 97 && currByte <= 122)) engLitCount++;
        }
        inputStream.close();
        System.out.println(engLitCount);

    }
}
