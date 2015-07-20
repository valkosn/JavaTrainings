package Orest.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;


/**
 * Created by Ra1004ek on 20.07.2015.
 */
public class PerformanceTestSerg
{
    final static String SELECT = "Select anyone: ";
    static Class fibClass = Fibonacci.class;
    static Class superFibClass = SuperFibonacci.class;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException
    {

        globalMenu();

    }

    private static void globalMenu() throws IOException
    {
        System.out.print("Available calculating:\n" +
                "Fibonacci - 1\n" +
                "Super Fibonacci - 2\n" +
                "Exit - 0\n" +
                SELECT);

        while (true)
        {
            int choice = Integer.parseInt(reader.readLine());
            if (choice == 0 ) return;

            switch (choice)
            {
                case 1:
                    fibMenu();
                    break;

                default:
                    System.out.print("Incorrect, retype pls\n" + SELECT);
                    break;

            }
        }
    }


    private static void fibMenu() throws IOException
    {
        System.out.println("Fibonacci calculating class\n" + "Available methods:");

        for (Method method : fibClass.getDeclaredMethods())
        {
            if (method.getModifiers() == 9) System.out.println(method.getName());
        }

        while (true)
        {
            int choice = Integer.parseInt(reader.readLine());
            switch (choice)
            {
                case 0:
                    globalMenu();
            }

        }

    }

}
