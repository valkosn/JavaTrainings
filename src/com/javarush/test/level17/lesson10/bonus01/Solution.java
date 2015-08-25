package com.javarush.test.level17.lesson10.bonus01;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution
{
    public static List<Person> allPeople = new ArrayList<Person>();

    static
    {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException
    {
        //start here - начни тут




        switch (args[0])
        {
            case "-c":
            {
                Person person;
                Date bd = parseStrToDate(args[3]);


                if ("м".equals(args[2])) person = Person.createMale(args[1], bd);
                else if ("ж".equals(args[2])) person = Person.createFemale(args[1], bd);
                else
                {
                    return;
                }
                allPeople.add(person);
                System.out.println(allPeople.indexOf(person));


            }
            break;
            case "-u":
            {
                Person person = allPeople.get(Integer.parseInt(args[1]));

                if ("м".equals(args[3])) person.setSex(Sex.MALE);
                else if ("ж".equals(args[3])) person.setSex(Sex.FEMALE);
                else return;


                person.setName(args[2]);
                person.setBirthDay(parseStrToDate(args[4]));

            }
            break;
            case "-d":
            {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setSex(null);
                person.setBirthDay(null);


            }
            break;
            case "-i":
            {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                String date;
                String sex = null;
                if (person.getSex() == Sex.MALE) sex = "м";
                else if (person.getSex() == Sex.FEMALE) sex = "ж";
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                date = dateFormat.format(person.getBirthDay());

                System.out.println(person.getName() + " " + sex + " " + date);

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
