package Orest.test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Ra1004ek on 16.07.2015.
 */
public class SuperFibonacci
{
    final static String mIncorrect = "Value m is incorrect, must be >=2";

    public static void main(String[] args)
    {
        System.out.println(superFibCycleImpl(9, 4));
        System.out.println(superFibCycleImpl(7, 3));
        System.out.println(superFibCycleImpl(9, 5));
        System.out.println(superFibCycleImpl(2, 4));
        System.out.println(superFibCycleImpl(1, 1));
    }

    public static long superFibArrayImpl(int n, int m)
    {

        ArrayList<Long> result = new ArrayList<>();

        if (m >= 2)
        {
            for (int i = 0; i < m; i++)
            {
                result.add(1L);
            }
            for (int i = m; i < n; i++)
            {
                long temp = 0;
                for (int y = i - m; y < i; y++)
                {
                    temp += result.get(y);
                }
                result.add(temp);

            }


        } else System.out.println(mIncorrect);


        return result.get(n - 1);
    }

    public static long superFibCycleImpl(int n, int m)
    {
        long result = 0;
        if (m >= 2)
        {
            if (m >= n) return 1;
            else
            {
                LinkedList<Long> list = new LinkedList<>();
                for (int i = 0; i < m; i++)
                {
                    list.add(1L);
                }

                for (int i = m; i < n; i++)
                {
                    result = 0;
                    for (Long l : list) result += l;

                    list.removeFirst();
                    list.add(result);

                }

            }


        } else System.out.println(mIncorrect);


        return result;

    }

    public static long superFibRecImpl(int n, int m)

    {
        if (m >= 2)
        {
            if (m >= n) return 1;
            else
            {

            }

        } else System.out.println(mIncorrect);

        return 0;
    }
}


