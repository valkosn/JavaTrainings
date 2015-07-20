package Orest.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by vsn on 15.07.15.
 */
public class Fibonacci
{
    private static long[] result = new long[500];
    private static int maxGenerated = 2;
    static
    {
        result[0] = 0L;
        result[1] = 1L;
    }



    public static int getN(BufferedReader reader) throws IOException
    {
        System.out.print("Enter the order of the Fibonacci numbers - ");
        return Integer.parseInt(reader.readLine());
    }

    public static long arrayOrestImpl(int n)
    {
        int absN = Math.abs(n);
        for (; maxGenerated <= absN; maxGenerated++)
        {
            result[maxGenerated] = result[maxGenerated - 1] + result[maxGenerated - 2];
        }
        return n > 1 ? result[absN] : -result[absN];
    }

    public static long arrayImpl(int n)
    {
        if (decision(n))
        {
            return n;
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

    public static long cycleImpl(int n)
    {
        if (decision(n))
        {
            return n;
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

    public static long recImpl(int n)
    {
        if (decision(n))
        {
            return n;
        }
        return n > 1 ? recImpl(n - 1) + recImpl(n - 2) : -(recImpl(Math.abs(n) - 1) + recImpl(Math.abs(n) - 2));
    }

    public static long bineImpl(int n)
    {
        long result = Math.round(Math.pow(((1 + Math.sqrt(5)) / 2), Math.abs(n)) / Math.sqrt(5));
        return n >= 0 ? result : -result;
    }

    private static boolean decision(int n)
    {
        switch (n) {
            case 0:
            case 1:
            case -1:
                return true;
            default:
                return false;
        }
    }

    enum Implementations
    {
        EXIT("Exit"),
        UNKNOWN_IMPL("Unknown impl"),
        ARRAY_IMPL("Array impl"),
        OREST_ARRAY_IMPL("Orest Array impl"),
        CYCLE_IMPL("Cycle impl"),
        RECURSIVE_IMPL("Recursive impl"),
        BINE_IMPL("Bine impl");

        private String message;

        Implementations(String message)
        {
            this.message = message;
        }

        public String getMessage()
        {
            return message;
        }

        public static Implementations get(String choose)
        {
            switch (choose) {
                case "1":
                    return ARRAY_IMPL;
                case "2":
                    return OREST_ARRAY_IMPL;
                case "3":
                    return CYCLE_IMPL;
                case "4":
                    return RECURSIVE_IMPL;
                case "5":
                    return BINE_IMPL;
                case "0":
                    return EXIT;
            }

            return UNKNOWN_IMPL;
        }
    }
}
