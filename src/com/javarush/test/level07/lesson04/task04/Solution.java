package com.javarush.test.level07.lesson04.task04;

/*
4. ������ �� ����� � �������� �������

1. ������� ������ �� 10 �����.
2. ������ � ���������� 10 ����� � �������� �� � ������.
3. ����������� �������� ������� � �������� �������.
4. ������� ��������� �� �����, ������ �������� �������� � ����� ������.

 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] numbers = new int[10];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++)
        {
            numbers[i] = Integer.parseInt(reader.readLine());
        }


        for (int i = 9; i >= 0; i--)
        {
            System.out.println(numbers[i]);
        }


    }
}
