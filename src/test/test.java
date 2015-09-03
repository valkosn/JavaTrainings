package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Created by vsn on 03.09.15.
 */
public class test
{
    public static void main(String[] args) throws Exception
    {
        String str = "?????? ?????!!";
        char[] arrStr = str.toCharArray();
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/vsn/test12"));


        writer.write(arrStr, 0, arrStr.length);
        writer.close();

    }
}
