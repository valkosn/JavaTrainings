package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args)
    {
        //start here - начни тут
        switch (args[0])
        {
            case "-c":
            {
                if (((args.length - 1) % 3) != 0) return;

                Person person;
                int count = 0;


                for (int i = 0; i < (args.length - 1) / 3; i++)
                {
                    String name = args[1 + count];
                    String sex = args[2 + count];
                    Date bd = parseStrToDate(args[3 + count]);


                    if ("м".equals(sex)) person = Person.createMale(name, bd);
                    else if ("ж".equals(sex)) person = Person.createFemale(name, bd);
                    else
                    {
                        return;
                    }
                    allPeople.add(person);
                    System.out.println(allPeople.indexOf(person));
                    count +=3;
                }


            }
            break;
            case "-u":
            {

                if (((args.length - 1) % 4) != 0) return;

                Person person;
                int count = 0;

                for (int i = 0; i < (args.length - 1) / 4; i++)
                {
                    int index = Integer.parseInt(args[1 + count]);
                    String name = args[2 + count];
                    String sex = args[3 + count];
                    Date bd = parseStrToDate(args[4 + count]);

                    person = allPeople.get(index);

                    if ("м".equals(sex)) person.setSex(Sex.MALE);
                    else if ("ж".equals(sex)) person.setSex(Sex.FEMALE);
                    else return;


                    person.setName(name);
                    person.setBirthDay(bd);
                    count += 4;
                }

            }
            break;
            case "-d":
            {
                Person person;

                for (int i = 1; i < args.length; i++)
                {

                    person = allPeople.get(Integer.parseInt(args[i]));
                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDay(null);
                }


            }
            break;
            case "-i":
            {
                Person person;

                for (int i = 1; i < args.length; i++)
                {


                    person = allPeople.get(Integer.parseInt(args[i]));
                    String date;
                    String sex = null;
                    if (person.getSex() == Sex.MALE) sex = "м";
                    else if (person.getSex() == Sex.FEMALE) sex = "ж";
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                    date = dateFormat.format(person.getBirthDay());

                    System.out.println(person.getName() + " " + sex + " " + date);
                }

            }
            break;

        }


    }

    private static Date parseStrToDate(String inDate)
    {

        Date outDate = null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        try
        {
            outDate = dateFormat.parse(inDate);

        }
        catch (ParseException e)
        {

        }
        return outDate;
    }
}

