package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int num1 = 0;
        int num2 = 0;


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            num1 = Integer.parseInt(reader.readLine());
            num2 = Integer.parseInt(reader.readLine());
        }
        catch (Exception e)
        {

        }

        if (num1 > 0 && num2 > 0) System.out.println(getDivider(num1, num2));

    }

    private static int getDivider(int num1, int num2)
    {
        int divider = 1;
        int maxDivider = (num1 < num2) ? num1 : num2;

        for (int i = 1; i <= maxDivider; i++)
        {
            if (num1 % i == 0 && num2 % i == 0) divider = i;
        }

        return divider;
    }
}
