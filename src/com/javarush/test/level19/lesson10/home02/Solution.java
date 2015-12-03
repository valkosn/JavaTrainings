package com.javarush.test.level19.lesson10.home02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/
//TODO:done
public class Solution {
    public static void main(String[] args) throws IOException {


        String fileName = args[0];
        Map<String, Double> resultMap = new HashMap<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String name = line.split(" ")[0];
            Double value = Double.parseDouble(line.split(" ")[1]);
            Double tempValue = resultMap.get(name);
            if (tempValue == null) resultMap.put(name, value);
            else resultMap.put(name, tempValue + value);
        }

        bufferedReader.close();

        Double maxValue = Collections.max(resultMap.values());
        List<String> maxName = resultMap.keySet().stream().filter(key -> Objects.equals(resultMap.get(key), maxValue)).collect(Collectors.toList());
        maxName.forEach(System.out::println);
    }
}
