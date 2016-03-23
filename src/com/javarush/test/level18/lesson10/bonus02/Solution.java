package com.javarush.test.level18.lesson10.bonus02;

import java.io.*;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/
//TODO:done
public class Solution
{

    private static final int ID_LENGTH = 8;
    private static final int PRODUCT_NAME_LENGTH = 30;
    private static final int PRICE_LENGTH = 8;
    private static final int QUANTITY_LENGTH = 4;
    private static String fileCrUDPath;


    public static void main(String[] args) throws Exception
    {

        setFileCrUDPathFromConsole();

        String operationType = args[0];
        String productName = args[1];
        String price = args[2];
        String quantity = args[3];

        switch (operationType)
        {
            case "-c":
                addObjectToCrUD(productName, price, quantity);
                break;
            case "-r":
                readObjectFromCrUD();
                break;
            case "-d":
                deleteObjectFromCrUD();
                break;
            default:
                throw new IllegalArgumentException("Incorrect operation type");
        }


    }

    private static String correctLength(String inputString, int inputLength)
    {

        while (inputString.length() < inputLength)
        {
            inputString += " ";
        }
        return inputString.length() > inputLength ? inputString.substring(0, inputLength) : inputString;
    }

    private static void deleteObjectFromCrUD()
    {

    }

    private static String readObjectFromCrUD()
    {
        return null;
    }

    private static void addObjectToCrUD(String productName, String price, String quantity)
    {
        Integer id = 1;
        try
        {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileCrUDPath));
            while (fileReader.ready())
            {
                String currId = fileReader.readLine().substring(0, ID_LENGTH).trim();
                id = Integer.parseInt(currId) + 1;
            }
            fileReader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        String stringForWrite = correctLength(id.toString(), ID_LENGTH) + correctLength(productName, PRODUCT_NAME_LENGTH)
                + correctLength(price, PRICE_LENGTH) + correctLength(quantity, QUANTITY_LENGTH);
        try
        {
            PrintStream printStream = new PrintStream(new FileOutputStream(fileCrUDPath, true), true);
            printStream.println(stringForWrite);
            printStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private static void setFileCrUDPathFromConsole()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            fileCrUDPath = reader.readLine();
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
