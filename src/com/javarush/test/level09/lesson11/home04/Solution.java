package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("M/dd/yyyy", Locale.ENGLISH);
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        Date date = new Date();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputDate = reader.readLine();
        date = inputDateFormat.parse(inputDate);
        System.out.println(outputDateFormat.format(date).toUpperCase());




         //напишите тут ваш код
    }
}
