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

public class DateParser {
    private static String year = "Year - ";
    private static String month = "Month - ";
    private static String day = "Day - ";

    public static void main(String[] args) throws IOException {
        String data = "2015.11.26";

        parseDate(initPattern(), data);

    }

    public static Pattern initPattern() {
        StringBuilder commonPattern = new StringBuilder();
        commonPattern.append("^((19[7-9]\\d)|(20[01]\\d))"); // year regex
        commonPattern.append("\\.((0[1-9])|(1[0-2]))"); // month regex
        commonPattern.append("\\.((0[1-9])|([12][0-9])|(3[0-1]))"); // day regex

        Pattern pattern = Pattern.compile(commonPattern.toString());

        return pattern;

    }


    public static void parseDate(Pattern pattern, String data) {
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            year += matcher.group(1); // magic
            month += matcher.group(4);  // magic
            day += matcher.group(7);  // magic
            System.out.println(year + "\n" + month + "\n" + day);

        } else

            System.out.println("Ops... No matches find");

    }

}
