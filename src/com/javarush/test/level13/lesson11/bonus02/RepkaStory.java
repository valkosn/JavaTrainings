package com.javarush.test.level13.lesson11.bonus02;

import java.util.List;

public class RepkaStory
{
    static void tell(List<Person> items) {

        Person first;
        Person second;
        for (int i = 0; i < items.size() - 1; i++) {
            first = items.get(items.size() - 1 - i);
            second = items.get(items.size() - 2 -i);
            first.pull(second);
        }
    }
}
