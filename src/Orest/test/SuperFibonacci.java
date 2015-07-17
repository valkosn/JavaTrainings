package Orest.test;

import java.util.ArrayList;

/**
 * Created by Ra1004ek on 16.07.2015.
 */
public class SuperFibonacci
{

    public static void main(String[] args)
    {

    }

    public static long superFibArrayImpl(int n, int m)
    {

        if (m >= 2)
        {
            ArrayList<Long> result = new ArrayList<>();
            for (int i = 0; i < m; i++)
            {
                result.add(1L);
            }
            for (int i = m; i < n - 1; i++)
            {

            }

        } else System.out.println("Value m is incorrect, must be >=2");


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


}
