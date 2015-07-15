package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name;
        int age;
        int weight;
        int growth;
        boolean sex;
        String race;

        public Human(String name)
        {
            this.name = name;
        }

        public Human(String name, int age)
        {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int weight, int growth)
        {
            this.name = name;
            this.weight = weight;
            this.growth = growth;
        }

        public Human(String name, boolean sex)
        {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, String race)
        {
            this.name = name;
            this.race = race;
        }

        public Human(String name, int age, int weight, int growth)
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.growth = growth;
        }

        public Human(String name, int age, int weight, int growth, String race)
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.growth = growth;
            this.race = race;
        }

        public Human(String name, int age, int weight, int growth, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.growth = growth;
            this.sex = sex;
        }

        public Human(String name, int weight, int growth, boolean sex, String race)
        {
            this.name = name;
            this.weight = weight;
            this.growth = growth;
            this.sex = sex;
            this.race = race;
        }

        public Human(String name, int age, int weight, int growth, boolean sex, String race)
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.growth = growth;
            this.sex = sex;
            this.race = race;
        }

        //напишите тут ваши переменные и конструкторы
    }
}
