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
    private static String year = "Year - ";
    private static String month = "Month - ";
    private static String day = "Day - ";

    public static void main(String[] args) throws IOException
    {
        Pattern pattern1 = Pattern.compile("^([12]\\d{3})\\.((0[1-9])|(1[0-2]))\\.((0[1-9])|([12][0-9])|(3[0-1]))");

        parseDate(pattern1, "2015.11.26");

    }

    public static void parseDate(Pattern pattern, String data)
    {
        Matcher matcher = pattern.matcher(data);
        if (matcher.find())
        {
            year += matcher.group(1);
            month += matcher.group(2);
            day += matcher.group(5);
            System.out.println(year + "\n" + month + "\n" + day);

        } else

            System.out.println("Ops... No matches find");

    }

}
