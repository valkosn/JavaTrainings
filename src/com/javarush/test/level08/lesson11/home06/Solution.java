package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {

        Human grandfather1 = new Human("grandfather1", true, 85, null);
        Human grandfather2 = new Human("grandfather2", true, 88, null);

        Human grandmother1 = new Human("grandmother1", false, 75, null);
        Human grandmother2 = new Human("grandmother2", false, 78, null);

        Human father = new Human("father", true, 48, null );
        Human mother = new Human("mother", false, 41, null);

        Human child1 =new Human("child1", true, 12,null);
        Human child2 =new Human("child2", true, 8,null);
        Human child3 =new Human("child3", false, 6,null);

        ArrayList<Human> children = new ArrayList<>();

        children.add(child1);
        children.add(child2);
        children.add(child3);


        System.out.println(grandfather1);
        System.out.println(grandfather2);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);

    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;

        }

        //напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }

            return text;
        }
    }

}
