package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/
//TODO:done
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        FileInputStream inputStream = new FileInputStream(args[0]);
        Map<Integer, Integer> resMap = new TreeMap<>();

        while (inputStream.available() > 0)
        {
            Integer tempChar = inputStream.read();
            Integer tempCharCount = resMap.get(tempChar);
            if (tempCharCount == null)
                resMap.put(tempChar, 1);
            else
            {
                resMap.put(tempChar, tempCharCount + 1);
            }
        }

        inputStream.close();

        for (int key : resMap.keySet())
        {
            System.out.println((char) key + " " + resMap.get(key));
        }

    }
}
