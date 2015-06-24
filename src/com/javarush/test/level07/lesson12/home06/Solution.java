package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {

        Human grandfather = new Human("Ded", false, 125, null, null);
        Human grandfather2 = new Human("Ded2", false, 85, null, null);
        Human grandmother = new Human("Babka", true, 225, null, null);
        Human grandmother2 = new Human("Babka2", true, 95, null, null);
        Human father = new Human("Father", true, 55, grandfather, grandmother);
        Human mother = new Human("Mother", true, 65, grandfather2, grandmother2);
        Human child1 = new Human("chi1", true, 5, father, mother);
        Human child2 = new Human("chi2", true, 15, father, mother);
        Human child3 = new Human("chi3", true, 25, father, mother);

        System.out.println(grandfather);
        System.out.println(grandmother);
        System.out.println(grandfather2);
        System.out.println(grandmother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);


        //напишите тут ваш код
    }

    public static class Human
    {

        String name;
        boolean sex;
        Human father;
        Human mother;
        int age;
        //напишите тут ваш код

        public Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;

        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
