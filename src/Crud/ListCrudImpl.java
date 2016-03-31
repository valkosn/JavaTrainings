/*
 * Copyright (c) 2016.
 */

package crud;

import test.Record;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by Valko Serhii on 28.03.2016.
 */
public class ListCrudImpl
{
    private static final int ID_LENGTH = 8;
    private static final int PRODUCT_NAME_LENGTH = 30;
    private static final int PRICE_LENGTH = 8;
    private static final int QUANTITY_LENGTH = 4;
    private static final String DELIMITER = "";
    private static boolean isModify;
    private static long lastSave;
    private long saveDelay = 1000;

    private static LinkedList<String> crUDList = new LinkedList<>();
    private static String fileCrUDPath;

    public ListCrudImpl(String fileCrUDPath)
    {
        ListCrudImpl.fileCrUDPath = fileCrUDPath;
        File file = new File(fileCrUDPath);
        try
        {
            if (!file.exists()) file.createNewFile();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.ready())
            {
                crUDList.add(reader.readLine());
            }
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public ListCrudImpl(String fileCrUDPath, int saveDelay)
    {
        this(fileCrUDPath);
        this.saveDelay = saveDelay;
    }

    public void create(String productName, double price, int quantity)
    {
        int id = 1;
        if (!crUDList.isEmpty())
        {
            int currID = Integer.parseInt(crUDList.getLast().substring(0, ID_LENGTH).trim());
            id = currID > id ? currID : id;
            id++;
        }
        crUDList.add(createStringForWrite(id, productName, price, quantity));
        isModify = true;
    }

    public String read(int targetID)
    {
        for (String s : crUDList)
        {
            if (isTargetString(s, targetID))
            {
                return s;
            }
        }
        return null;
    }

    @Deprecated
    public Record readAsRec(int targetID)
    {
        String result = null;
        for (String s : crUDList)
        {
            if (isTargetString(s, targetID))
            {
                result = s;
                break;
            }
        }
        if (result != null)
        {
            int id = Integer.parseInt(result.substring(0, ID_LENGTH).trim());
            String productName = result.substring(ID_LENGTH + 1, PRODUCT_NAME_LENGTH).trim();
            double price = Double.parseDouble(result.substring(PRODUCT_NAME_LENGTH + 1, PRICE_LENGTH).trim());
            int quantity = Integer.parseInt(result.substring(PRICE_LENGTH + 1, QUANTITY_LENGTH).trim());
            return new Record(id, productName, price, quantity);
        } else return null;
    }

    public boolean update(int id, String productName, double price, int quantity)
    {
        int index = -1;

        for (String s : crUDList)
        {
            if (isTargetString(s, id)) index = crUDList.indexOf(s);
        }
        if (index == -1) return false;
        crUDList.set(index, createStringForWrite(id, productName, price, quantity));
        isModify = true;
        return true;
    }

    public boolean delete(int id)
    {
        int index = -1;

        for (String s : crUDList)
        {
            if (isTargetString(s, id)) index = crUDList.indexOf(s);
        }
        if (index == -1) return false;
        crUDList.remove(index);
        isModify = true;
        return true;
    }

    @Deprecated
    public boolean reindex()
    {

        return true;
    }

    public void save()
    {
        long currantTime = System.currentTimeMillis();
        if (isModify && (lastSave + saveDelay) < currantTime)
        {
            try
            {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileCrUDPath));
                for (String s : crUDList)
                {
                    writer.write(s + "\n");
                }
                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        lastSave = System.currentTimeMillis();
    }

    private static boolean isTargetString(String s, int id)
    {
        return Integer.parseInt(s.substring(0, ID_LENGTH).trim()) == id;
    }

    private static String correctLength(String inputString, int inputLength)
    {
        return inputString.length() < inputLength ? String.format("%-" + inputLength + "s", inputString) :
                inputString.length() > inputLength ? inputString.substring(0, inputLength) : inputString;
    }

    private static String createStringForWrite(Integer id, String productName, Double price, Integer quantity)
    {
        return String.join(DELIMITER, correctLength(id.toString(), ID_LENGTH), correctLength(productName, PRODUCT_NAME_LENGTH),
                correctLength(price.toString(), PRICE_LENGTH), correctLength(quantity.toString(), QUANTITY_LENGTH));
    }


}
