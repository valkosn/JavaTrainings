package com.javarush.test.level19.lesson10.home01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/
//TODO:done
public class Solution {
    public static void main(String[] args) throws IOException
    {

        String fileName = args[0];
        Map<String, Double> resultMap = new TreeMap<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String name = line.split(" ")[0];
            Double value = Double.parseDouble(line.split(" ")[1]);
            Double tempValue = resultMap.get(name);
            if (tempValue == null) resultMap.put(name, value);
            else if (tempValue != null) resultMap.put(name, tempValue + value);
        }
        bufferedReader.close();

        for (String key : resultMap.keySet()) {

            System.out.println(key + " " + resultMap.get(key));
        }

    }
}
