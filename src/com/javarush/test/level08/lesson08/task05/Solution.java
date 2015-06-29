package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Pupkin", "Oleg");
        map.put("Zalupkin", "Oleg");
        map.put("Petrov", "Nikolay");
        map.put("Smirnov", "Semen");
        map.put("Her", "Xyj");
        map.put("DSA", "Xyj");
        map.put("Pup", "Oleg");
        map.put("Pupk", "Oleg");
        map.put("Pupkee", "Oleg");
        map.put("Puprrrk", "Oleg");
        //напишите тут ваш код
            return (HashMap<String,String>)map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashSet<String> set = new HashSet<String>();
        HashMap<String, String> copy = new HashMap<String, String>(map);
        Iterator<String> iterator = copy.values().iterator();
        while (iterator.hasNext()) {
            String temp = iterator.next();
            if (!set.add(temp)) removeItemFromMapByValue(map, temp);
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }


}
