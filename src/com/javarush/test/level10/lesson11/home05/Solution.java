package com.javarush.test.level10.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита).  Вывести результат на экран.
Пример вывода:
а 5
б 8
в 3
г 7
…
я 9
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++)
        {
            alphabet.add(abcArray[i]);
        }

        //ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        HashMap<Character, Integer> result = new HashMap();
        for (Character x : alphabet)
        {
            int counter = 0;
            for (String y : list)
            {
                char[] tempChars = y.toCharArray();
                for (int i = 0; i < tempChars.length; i++)
                {
                    if(tempChars[i] == x) counter++;
                }

            }
            result.put(x, counter);
        }

        for(Character x :alphabet){
            System.out.println(x + " " + result.get(x));


        }


        //напишите тут ваш код
    }

}
