package com.javarush.test.level18.lesson10.bonus02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
//D:\testTemp.txt
//-c "Шорты пляжные23" 159.00 12
//-r 5
//-u 3 "Шорты пляжные" 250.00 167
//-d 2

public class Solution
{

    private static final int ID_LENGTH = 8;
    private static final int PRODUCT_NAME_LENGTH = 30;
    private static final int PRICE_LENGTH = 8;
    private static final int QUANTITY_LENGTH = 4;
    private static final String DELIMITER = "";
    private static String fileCrUDPath;


    public static void main(String[] args) throws Exception
    {
        setFileCrUDPathFromConsole();

        String operationType = args[0];
        String productName;
        String price;
        String quantity;
        String id;

        switch (operationType)
        {
            case "-c":
                productName = args[1];
                price = args[2];
                quantity = args[3];

                createObjectInCrUD(productName, price, quantity);
                break;

            case "-r":
                id = args[1];
                System.out.println(readObjectFromCrUD(id));
                break;

            case "-u":
                id = args[1];
                productName = args[2];
                price = args[3];
                quantity = args[4];

                updateObjectInCrUD(id, productName, price, quantity);
                break;

            case "-d":
                id = args[1];

                deleteObjectFromCrUD(id);
                break;

            default:
                throw new IllegalArgumentException("Incorrect operation type");
        }
    }

    public static void createObjectInCrUD(String productName, String price, String quantity, String delimiter)
    {
        Integer id = readCrUDFile((fileReader, localCrUDList) -> {

            String currId = fileReader.readLine().substring(0, ID_LENGTH).trim();
            return Integer.parseInt(currId) + 1;
        });

        if (id == null) id = 1;
        String stringForWrite = createStringForWrite(delimiter, id.toString(), productName, price, quantity);
        writeCrUDFile(() -> stringForWrite, true);
    }

    public static void createObjectInCrUD(String productName, String price, String quantity)
    {
        createObjectInCrUD(productName, price, quantity, DELIMITER);
    }

    public static String readObjectFromCrUD(String id)
    {
        return readCrUDFile((bufferedReader, localCrUDList) -> {

            String result = bufferedReader.readLine();

            return result.substring(0, ID_LENGTH).trim().equals(id) ? result : null;
        });
    }

    public static boolean updateObjectInCrUD(String id, String productName, String price, String quantity)
    {
        List<String> crUDList = readCrUDFile((bufferedReader, localCrUDList) -> {
            localCrUDList.add(bufferedReader.readLine());
            return localCrUDList;
        });

        int index = -1;
        for (String item : crUDList)
        {
            if (item.substring(0, ID_LENGTH).trim().equals(id)) index = crUDList.indexOf(item);
        }
        if (index == -1) return false;
        crUDList.set(index, createStringForWrite(DELIMITER, id, productName, price, quantity));
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileCrUDPath));
            for (String s : crUDList)
            {
                writer.write(s + "\n");
            }
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public static void deleteObjectFromCrUD(String id)
    {
        updateObjectInCrUD(id, correctLength("", PRODUCT_NAME_LENGTH), correctLength("", PRICE_LENGTH),
                                correctLength("", QUANTITY_LENGTH));
    }

    private static String correctLength(String inputString, int inputLength)
    {
        return inputString.length() < inputLength ? String.format("%-" + inputLength + "s", inputString) :
                inputString.length() > inputLength ? inputString.substring(0, inputLength) : inputString;
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

    private static String createStringForWrite(String delimiter, String id, String productName, String price, String quantity)
    {
        return String.join(delimiter, correctLength(id, ID_LENGTH), correctLength(productName, PRODUCT_NAME_LENGTH),
                correctLength(price, PRICE_LENGTH), correctLength(quantity, QUANTITY_LENGTH));
    }

    private static <R> R readCrUDFile(MyFunction<R> function)
    {
        R result = null;
        R preResult;
        List<String> localCrUDList = new ArrayList<>();
        try
        {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileCrUDPath));
            while (fileReader.ready())
            {
                preResult = function.apply(fileReader, localCrUDList);
                if (preResult != null) result = preResult;
            }
            fileReader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

    private static void writeCrUDFile(MySupplier supplier, boolean append)
    {
        try
        {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileCrUDPath, append));
            writer.write(supplier.get() + "\n");
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @FunctionalInterface
    private interface MyFunction<R>
    {
        R apply(BufferedReader bufferedReader, List<String> localCrUDList) throws Exception;
    }

    @FunctionalInterface
    private interface MySupplier<T>
    {
        T get();
    }
}
