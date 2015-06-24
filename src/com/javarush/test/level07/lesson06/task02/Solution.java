package com.javarush.test.level07.lesson06.task02;

/* 5 строчек: «101», «102», «103», «104», «105»
1. Создай список строк.
2. Добавь в него 5 строчек: «101», «102», «103», «104», «105».
3. Удали первую, среднюю и последнюю.
4. Используя цикл выведи на экран его содержимое, каждое значение с новой строки.
5. Выведи его размер. (После удаления одного элемента индексы остальных меняются.
Например, если удалить 0-й элемент, то тот, который был 1-м, станет 0-м. И т.д.)
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("101");
        strings.add("102");
        strings.add("103");
        strings.add("104");
        strings.add("105");

        strings.remove(0);
        strings.remove(1);
        strings.remove(2);

        for (int i = 0; i < strings.size(); i++)
        {
            System.out.println(strings.get(i));
        }

        System.out.println(strings.size());
    }
}
