package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
    {

        PrintStream printStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(printStream);

        String[] firstResult = outputStream.toString().split(" ");
        outputStream.close();
        stream.close();
        int a = Integer.parseInt(firstResult[0]);
        int b = Integer.parseInt(firstResult[2]);

        switch (firstResult[1])
        {
            case "+":
            {
                System.out.println(a + " + " + b + " = " + (a+b));
            }

            break;
            case "-":
            {
                System.out.println(a + " - " + b + " = " + (a-b));
            }
            break;
            case "*":
            {
                System.out.println(a + " * " + b + " = " + (a*b));
            }
        }

        }

        public static class TestString
        {
            public void printSomething()
            {
                System.out.println("3 + 6 = ");
            }
        }
    }

