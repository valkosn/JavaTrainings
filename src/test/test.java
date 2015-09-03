package test;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Created by vsn on 03.09.15.
 */
public class test
{
    public static void main(String[] args) throws Exception
    {

        String str = "dfkgljdhfg 65324 dfgsdfg4654 321321вапыва ывап цукен вапывапЫВАПЫВП";


        char[] arrStr = str.toCharArray();
        BufferedWriter writer = new BufferedWriter(new FileWriter("d:\\test11.txt"));


        writer.write(arrStr, 0, arrStr.length);
        writer.close();

    }
}
