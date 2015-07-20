package Orest.test;

import java.util.ArrayList;

/**
 * Created by Ra1004ek on 16.07.2015.
 */
public class SuperFibonacci
{

    public static void main(String[] args)
    {
        System.out.println(superFibArrayImpl(6, 2));
        System.out.println(superFibArrayImpl(6, 3));
        System.out.println(superFibArrayImpl(6, 4));
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


        } else System.out.println("Value m is incorrect, must be >=2");


        return result.get(n - 1);
    }


}
