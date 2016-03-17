package test;


import com.javarush.test.level20.lesson02.task05.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Test
{
    public static void main(String[] args) throws IOException
    {
//        Test(new HashMap<>());
//        Test(new TreeMap<>());
//        Test(new LinkedHashMap<>());
//        List<Integer>list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        System.out.println(list.add(4));
//        System.out.println(list.get(2) + " " + list.size());
//        System.out.println(list.set(2,3));
//        System.out.println(list.get(2) + " " + list.size());

        int[] array = {6,9,8};
        List<Integer> list = new ArrayList<>();
        list.add(array[0]);
        list.add(array[2]);
        list.set(1, array[1]);
        list.remove( 0 );
        System.out.println(list);
//        Random rand = new Random();
//        final int ITERATION = 30;
//        final int BOUND = 20000;
//        int globalCount, count;
//        Integer i, y;
//        boolean noResult, tempResult;
//
//        for(int a = 0; a < ITERATION; a++)
//        {
//            globalCount = 0;
//            noResult = true;
//            while (noResult)
//            {
//                count = 0;
//                tempResult = true;
//                while (tempResult)
//                {
//                    count++;
//                    i = rand.nextInt(BOUND);
//                    y = rand.nextInt(BOUND);
//                    if (i.equals(y)) tempResult = false;
//                }
//                globalCount++;
//                if (count == 1) noResult = false;
//            }
//
//            System.out.println("gCount - " + globalCount);
//        }

    }

    @Override
    protected void finalize() throws Throwable
    {

        super.finalize();

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


