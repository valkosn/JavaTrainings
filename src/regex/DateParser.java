/*
 * Copyright (c) 2015.
 */

package regex;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Valko Serhii on 26.11.2015.
 */

public class DateParser
{
    public static void main(String[] args) throws IOException
    {
        String year = "Year - ";
        String month = "Month - ";
        String day = "Day - ";

        String data = "2015.11.26";

        Pattern pattern = Pattern.compile("^([12]\\d{3})\\.((0[1-9])|(1[0-2]))\\.((0[1-9])|([12][0-9])|(3[0-1]))");
        Matcher matcher = pattern.matcher(data);

        matcher.find();
        try
        {
            year += matcher.group(1);
            month += matcher.group(2);
            day += matcher.group(5);
            System.out.println(year + "\n" + month + "\n" + day);

        }
        catch (IllegalStateException e)
        {
            System.out.println("Ops... I catch exception!");
        }

    }
}