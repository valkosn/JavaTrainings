package Orest.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by vsn on 20.07.15.
 */
public class PerformanceTest
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Availiable impementations:\n" +
                "Array impl - 1\n" +
                "Orest Array impl - 2\n" +
                "Cycle impl - 3\n" +
                "Recursive impl - 4\n" +
                "Bine impl - 5\n" +
                "EXIT - 0");

        while (true)
        {
            System.out.print("What implementation you want to use? - ");
            Fibonacci.Implementations impl = Fibonacci.Implementations.get(reader.readLine());

            if (impl.equals(Fibonacci.Implementations.EXIT))
            {
                return;
            }

            int n = Fibonacci.getN(reader);
            long lBegin = System.nanoTime();
            long result = 0;
            switch (impl)
            {
                case ARRAY_IMPL:
                    result = Fibonacci.arrayImpl(n);
                    break;
                case OREST_ARRAY_IMPL:
                    result = Fibonacci.arrayOrestImpl(n);
                    break;
                case CYCLE_IMPL:
                    result = Fibonacci.cycleImpl(n);
                    break;
                case RECURSIVE_IMPL:
                    result = Fibonacci.recImpl(n);
                    break;
                case BINE_IMPL:
                    result = Fibonacci.bineImpl(n);
                case UNKNOWN_IMPL:
                    break;
            }
            System.out.println(String.format("Result: %s \n\t%s elapsed time %s ns \n", result, impl.getMessage(), System.nanoTime() - lBegin));
        }
    }
}
