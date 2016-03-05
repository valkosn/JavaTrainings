package com.javarush.test.level23.lesson06.task01;

/* Как выбрать нужное?
В методе main присвойте объекту Object obj экземпляр класса TEST
Константу TEST и класс TEST менять нельзя.
*/
//TODO:new
public class Solution {
    public static final String TEST = "test";

    public static class TEST {
        @Override
        public String toString() {
            return "Test class";
        }
    }

    static Object obj;

    public static void main(String[] args) {
        obj = Solution.TEST;
        System.out.println(obj);
    }
}
