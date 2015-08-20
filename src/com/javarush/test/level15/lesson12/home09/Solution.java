package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        URL url = new URL(reader.readLine());


        Map<String, String> query_pairs = new LinkedHashMap<>();
        String query = url.getQuery();
        String[] pairs = query.split("&");
        for (String pair : pairs)
        {
            int idx = pair.indexOf("=");

            if (idx == -1) query_pairs.put(pair, null);
            else
                query_pairs.put(pair.substring(0, idx), pair.substring(idx + 1));
        }

        Set keys = query_pairs.keySet();

        for (Object x : keys)
        {
            System.out.print(x + " ");
        }

        System.out.println();


        if (query_pairs.containsKey("obj"))
        {
            try
            {
                alert(Double.parseDouble(query_pairs.get("obj")));
            }
            catch (Exception e)
            {
                alert(query_pairs.get("obj"));
            }
        }

    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}
