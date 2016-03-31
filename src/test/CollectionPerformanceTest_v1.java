package test;


import com.javarush.test.level20.lesson02.task05.Solution;

import java.io.IOException;
import java.util.*;

public class CollectionPerformanceTest_v1
{
    public static void main(String[] args) throws IOException
    {
        test(new HashMap<>());
        test(new TreeMap<>());
        test(new LinkedHashMap<>());
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.add(4));
        System.out.println(list.get(2) + " " + list.size());
        System.out.println(list.set(2, 3));
        System.out.println(list.get(2) + " " + list.size());
    }

    static void test(Map map)
    {

        long startTime;
        long stopTime;
        System.out.println(map.getClass().getName());

        startTime = System.nanoTime();

        for (int i = 1; i < 1000000; i++)
        {
            map.put(i, i + 5);
        }

        stopTime = System.nanoTime();
        System.out.println("Map filling time " + (stopTime - startTime));

        map.get(1);
        startTime = System.nanoTime();
        map.get(1);
        map.get(1);
        stopTime = System.nanoTime();
        System.out.println("First element access time " + (stopTime - startTime));

        map.get(5000000);
        startTime = System.nanoTime();
        map.get(5000000);
        map.get(5000000);
        stopTime = System.nanoTime();
        System.out.println("Middle element access time " + (stopTime - startTime));

        map.get(map.size());
        startTime = System.nanoTime();
        map.get(map.size());
        map.get(map.size());
        stopTime = System.nanoTime();
        System.out.println("Last element access time " + (stopTime - startTime) + "\n");

    }


}


