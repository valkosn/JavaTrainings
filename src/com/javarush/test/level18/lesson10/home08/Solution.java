package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/
//TODO:done
/*

E:\Work\test\test1.txt
E:\Work\test\test2.txt
E:\Work\test\test3.txt
E:\Work\test\test4.txt
exit

*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            String fileName = reader.readLine();
            if (fileName.equals("exit")) break;
            new ReadThread(fileName).start();
        }
        reader.close();

    }


    public static class ReadThread extends Thread
    {

        String fileName;

        public ReadThread(String fileName) throws Exception
        {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут


        public void run()
        {
            Map<Integer, Integer> tempMap = new HashMap<>();
            Integer maxByteByFrequency = null;

            try
            {
                FileInputStream fileInputStream = new FileInputStream(fileName);

                while (fileInputStream.available() > 0)
                {
                    Integer currByte = fileInputStream.read();
                    Integer currByteCount = tempMap.get(currByte);

                    if (currByteCount == null)
                        tempMap.put(currByte, 1);
                    else tempMap.put(currByte, ++currByteCount);
                }
                fileInputStream.close();
            }
            catch (IOException e)
            {
            }

            for (Integer key : tempMap.keySet())
            {

                int maxCount = 0;
                if (tempMap.get(key) > maxCount) maxByteByFrequency = key;
            }

            resultMap.put(fileName, maxByteByFrequency);


        }


    }
}
