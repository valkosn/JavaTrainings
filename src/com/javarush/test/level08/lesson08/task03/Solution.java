package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Pupkin", "Oleg");
        map.put("Zalupkin", "Oleg");
        map.put("Pupkin", "Roman");
        map.put("Petrov", "Oleg");
        map.put("Petrov", "Nikolay");
        map.put("Smirnov", "Semen");
        map.put("Her", "Xyj");
        map.put("DSA", "Xyj");
        map.put("Pup", "Oleg");
        map.put("Pupk", "Oleg");
        map.put("Pupkee", "Oleg");
        map.put("Puprrrk", "Oleg");


        return (HashMap<String, String>) map;
        //напишите тут ваш код

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();

            if (pair.getValue().equals(name)) count++;
        }
        return count;
        //напишите тут ваш код

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Map.Entry<String,String> pair = iterator.next();
            if (pair.getKey().equals(familiya)) count++;
        }

        return count;
    }


}
