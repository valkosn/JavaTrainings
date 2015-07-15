package Orest.test;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by vsn on 15.07.15.
 */
public class test1
{
    public static void main(String[] args) throws  Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the order of the Fibonacci numbers - ");
        int n =  Integer.parseInt(reader.readLine());

        long lBegin = System.nanoTime();
        System.out.print("Array impl result is " + fibonachiArrayImpl(n) + " elapsed time ");
        long lEnd = System.nanoTime();
        System.out.println(lEnd - lBegin + " ns");

        lBegin = System.nanoTime();
        System.out.print("Cycle impl result is " + fibonachiCycleImpl(n) + " elapsed time ");
        lEnd = System.nanoTime();
        System.out.println(lEnd - lBegin + " ns");

        lBegin = System.nanoTime();
        System.out.print("Recursive impl result is " + fibonachiRecImpl(n) + " elapsed time ");
        lEnd = System.nanoTime();
        System.out.println(lEnd - lBegin + " ns");

        lBegin = System.nanoTime();
        System.out.print("Bine impl result is " + fibonachiBineImpl(n) + " elapsed time ");
        lEnd = System.nanoTime();
        System.out.println(lEnd - lBegin + " ns");

    }

    public static long fibonachiArrayImpl(int n)
    {
        switch (n)
        {
            case 0:
                return 0;
            case 1:
                return 1;
            case -1:
                return -1;
        }
        ArrayList<Long> result = new ArrayList<>();
        result.add(0L);
        result.add(1L);
        for (int i = 2; i <= Math.abs(n); i++)
        {
            result.add(result.get(i - 1) + result.get(i - 2));
        }

        return n > 1 ? result.get(Math.abs(n)) : -result.get(Math.abs(n));
    }

    public static long fibonachiCycleImpl(int n)
    {
        switch (n)
        {
            case 0:
                return 0;
            case 1:
                return 1;
            case -1:
                return -1;
        }
        long result = 0;
        long temp0 = 0;
        long temp1 = 1;
        for (int i = 2; i <= Math.abs(n); i++)
        {
            result = temp0 + temp1;
            temp0 = temp1;
            temp1 = result;
        }

        return n > 1 ? result : -result;

    }

    public static long fibonachiRecImpl(int n)
    {
        switch (n)
        {
            case 0:
                return 0;
            case 1:
                return 1;
            case -1:
                return -1;
        }
        return n > 1 ? fibonachiRecImpl(n - 1) + fibonachiRecImpl(n - 2) :
                -(fibonachiRecImpl(Math.abs(n) - 1) + fibonachiRecImpl(Math.abs(n) - 2));


    }

    public static long fibonachiBineImpl(int n)
    {

        long result = Math.round(Math.pow(((1 + Math.sqrt(5)) / 2), Math.abs(n)) / Math.sqrt(5));

        return n >= 0 ? result : -result;

//        return n >= 0 ? (long) ((Math.pow(((1 + Math.sqrt(5)) / 2), n) - Math.pow(((1 - Math.sqrt(5)) / 2), n)) / Math.sqrt(5)) :
//                (long) -((Math.pow(((1 + Math.sqrt(5)) / 2), n) - Math.pow(((1 - Math.sqrt(5)) / 2), n)) / Math.sqrt(5));

    }

}
