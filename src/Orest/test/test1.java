package Orest.test;

/**
 * Created by vsn on 15.07.15.
 */
public class test1
{
    public static void main(String[] args)
    {
        System.out.println(fibonachi(0));
        System.out.println(fibonachi(1));
        System.out.println(fibonachi(5));
        System.out.println(fibonachi(-5));
        System.out.println(fibonachi(16));
        System.out.println(fibonachi(-16));
    }

    public static long fibonachi(int n)
    {
        if (n >= 0)
        {
            switch (n)
            {
                case 0:
                    return 0;
                case 1:
                    return 1;
                default:
                    return fibonachiNumbers(n);
            }
        } else
        {
            return Math.abs(n) == 1 ? -1 : 0 - fibonachiNumbers(Math.abs(n));
        }
    }

    private static long fibonachiNumbers(int n)
    {
        long[] temp = new long[n];
        temp[0] = 0;
        temp[1] = 1;
        for (int i = 2; i <= temp.length - 1; i++)
        {
            temp[i] = temp[i - 1] + temp[i - 2];
        }
        return temp[n - 1];
    }

}
