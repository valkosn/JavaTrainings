package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(10.0, "fff");
        labels.put(12.0, "fffr");
        labels.put(50.0, "ffffcf");
        labels.put(17.0, "fdfff");
        labels.put(70.0, "ff548f");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
