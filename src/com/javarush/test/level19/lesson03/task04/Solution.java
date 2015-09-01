package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        File file = new File("d:\\test1.txt");
        PersonScannerAdapter test = new PersonScannerAdapter(new Scanner(file));
        System.out.println(test.read());
    }

    public static class PersonScannerAdapter implements PersonScanner
    {

        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException
        {
            String[] data = scanner.nextLine().split(" ");
            Date bd = new Date(Integer.parseInt(data[5]), Integer.parseInt(data[4]), Integer.parseInt(data[3]));


            return new Person(data[2], data[1], data[0], bd);
        }

        @Override
        public void close() throws IOException
        {
            this.scanner.close();
        }
    }
}
