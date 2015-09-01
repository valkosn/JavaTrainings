package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public static Map<String, String> countries = new HashMap<String, String>();

    static
    {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args)
    {
        IncomeDataAdapter test = new IncomeDataAdapter(new IncomeData()
        {
            @Override
            public String getCountryCode()
            {
                return "UA";
            }

            @Override
            public String getCompany()
            {
                return "Home";
            }

            @Override
            public String getContactFirstName()
            {
                return "Sergey";
            }

            @Override
            public String getContactLastName()
            {
                return "Valko";
            }

            @Override
            public int getCountryPhoneCode()
            {
                return 38;
            }

            @Override
            public int getPhoneNumber()
            {
                return 635979701;
            }
        });

        System.out.println(test.getName());
        System.out.println(test.getCompanyName());
        System.out.println(test.getCountryName());
        System.out.println(test.getPhoneNumber());
    }

    public static interface IncomeData
    {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer
    {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact
    {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }

    public static class IncomeDataAdapter implements Customer, Contact
    {

        private IncomeData incomeData;

        public IncomeDataAdapter(IncomeData incomeData)
        {

            this.incomeData = incomeData;
        }

        private static String validNumber(String number)
        {

            return number.length() < 10 ? validNumber("0" + number) : number;
        }

        @Override
        public String getName()
        {
            return this.incomeData.getContactLastName() + ", " + this.incomeData.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {
            String result = "+" + this.incomeData.getCountryPhoneCode();
            String phoneNumber = validNumber(Integer.toString(this.incomeData.getPhoneNumber()));


            result = result + "(" + phoneNumber.substring(0, 3) + ")" + phoneNumber.substring(3, 6) + "-"
                    + phoneNumber.substring(6,8) + "-" + phoneNumber.substring(8,10);


            return result;
        }

        @Override
        public String getCompanyName()
        {
            return this.incomeData.getCompany();
        }

        @Override
        public String getCountryName()
        {
            return countries.get(this.incomeData.getCountryCode());
        }
    }
}