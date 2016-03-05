package com.javarush.test.level20.lesson04.task04;

import java.io.Serializable;

/* Как сериализовать static?
Сделайте так, чтобы сериализация класса ClassWithStatic была возможной
*/
public class Solution {
    public static class ClassWithStatic implements Serializable{
        public static String staticString = "it's Test static string";
        public int i;
        public int j;
    }
}
