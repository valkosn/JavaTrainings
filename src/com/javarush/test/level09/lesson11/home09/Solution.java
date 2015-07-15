package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> map = new HashMap<>();
        map.put("qqwwee", new Cat("qqwwee"));
        map.put("qqww", new Cat("qqww"));
        map.put("qqwwe", new Cat("qqwwe"));
        map.put("qqw", new Cat("qqw"));
        map.put("qqwsdf", new Cat("qqwsdf"));
        map.put("qqsdfdf", new Cat("qqsdfdf"));
        map.put("qqwryrt", new Cat("qqwryrt"));
        map.put("qqbnmn", new Cat("qqbnmn"));
        map.put("qqwqweq", new Cat("qqwqweq"));
        map.put("qqwwerr", new Cat("qqwwerr"));
        return map;
        //напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
       Set<Cat> set =  new HashSet<>();
        for(Cat x : map.values()) {
           set.add(x);
       }
        //напишите тут ваш код
        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
