/*
 * Copyright (c) 2016.
 */

package test;

import java.util.*;
import java.util.function.Supplier;

/**
 * Created by Valko Serhii on 14.03.2016.
 */
public class CollectionPerformanceTest_v2
{
    public static void main(String[] args)
    {
        testMap(new HashSet<>());
        testMap(new TreeSet<>());
        testMap(new ArrayList<>());
    }

    private static void testMap(Collection<Integer> map)
    {
        test(() -> {
            for (int i = 100; i >= 0; i--)
            {
                map.add(i);
                // System.out.println(i + 5);
            }
            // System.out.println(map);
            return map.getClass();
        });

        test(() -> {
            map.contains(rand(1, 500000));
            map.size();
            return map.getClass();
        });

        test(() -> {
            map.contains(rand(250000, 750000));
            return map.getClass();
        });

        test(() -> {
            map.contains(rand(500000, 1000000));
            return map.getClass();
        });

        System.out.println();
    }

    public static void test(Supplier<Class<? extends Collection>> myType)
    {
        int n = 1000;
        long start = System.nanoTime() / n;
        Class<? extends Collection> clazz = null;
        int [] a = {1, 2 };
        int b = a.length;
        for (int i = 0; i < 5000; i++)
        {
            clazz = myType.get();
        }
        System.out.println(clazz.getName() + " time " + (System.nanoTime() / n - start));
    }

    private static int rand(int min, int max)
    {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
