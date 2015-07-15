package com.javarush.test.level10.lesson11.home04;

/* Большая зарплата
Вывести на экран надпись «Я не хочу изучать Java, я хочу большую зарплату» 40 раз по образцу.
Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
…
*/

import javax.xml.stream.events.Characters;
import java.util.LinkedList;

public class Solution
{
    public static void main(String[] args)
    {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        LinkedList<Character> test = new LinkedList<>();
        char[] sChars= s.toCharArray();
        for (int i = 0; i < sChars.length; i++)
        {
            test.add(sChars[i]);
        }
        for (int j = 0; j < 40; j++)
        {
            for (Character x : test)
            {
                System.out.print(x);
            }
            test.removeFirst();
            System.out.println("");

        }

        //напишите тут ваш код
    }

}
