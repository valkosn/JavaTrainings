package com.javarush.test.level18.lesson10.home09;

import java.io.*;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/
//TODO:done...
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {

            String filePath = reader.readLine();
            try
            {
                readFromConsole(filePath);
            }
            catch (FileNotFoundException e)
            {
                System.out.println(filePath);
                break;
            }
            catch (IOException e)
            {

            }

        }
        reader.close();
    }

    public static void readFromConsole(String filePath) throws IOException
    {
        FileInputStream inputStream = new FileInputStream(filePath);
        inputStream.close();


    }
}
