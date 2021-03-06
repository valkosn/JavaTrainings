package com.javarush.test.level18.lesson10.home10;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/
//TODO:done
/*

E:\Work\Test\Test.txt.part7
E:\Work\Test\Test.txt.part2
E:\Work\Test\Test.txt.part4
E:\Work\Test\Test.txt.part3
E:\Work\Test\Test.txt.part1
E:\Work\Test\Test.txt.part6
E:\Work\Test\Test.txt.part5
end

*/
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> filesMap = new TreeMap<>();
        while (true) {
            String fileFullPath = reader.readLine();
            if (fileFullPath.equals("end")) break;
            File file = new File(fileFullPath);
            Integer partNumber = Integer.parseInt(file.getName().split("part")[1]);

            filesMap.put(partNumber, file.getPath());

        }
        reader.close();


        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filesMap.get(1).split(".part")[0]));

        for (Integer key : filesMap.keySet()) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filesMap.get(key)));

            while (bufferedReader.ready()) {

                bufferedWriter.write(bufferedReader.read());
            }

            bufferedReader.close();
        }

        bufferedWriter.close();
    }
}
