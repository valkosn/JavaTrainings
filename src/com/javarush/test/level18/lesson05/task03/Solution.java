package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inFilePath = reader.readLine();
        String outFilePath1 = reader.readLine();
        String outFilePath2 = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(inFilePath);
        FileOutputStream outputStream1 = new FileOutputStream(outFilePath1);
        FileOutputStream outputStream2 = new FileOutputStream(outFilePath2);

        int sizefile2 = inputStream.available() / 2;
        int sizefile1 = inputStream.available() - sizefile2;

        while (sizefile1 > 0)
        {
            int data = inputStream.read();
            outputStream1.write(data);
            sizefile1--;
        }
        while (sizefile2 > 0) {

            int data = inputStream.read();
            outputStream2.write(data);
            sizefile2--;
        }

        inputStream.close();
        outputStream1.close();
        outputStream2.close();


    }
}
