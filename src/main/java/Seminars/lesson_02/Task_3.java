package Seminars.lesson_02;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Запишите в файл следующие строки:
 * Анна=4
 * Елена=5
 * Марина=6
 * Владимир=?
 * Полина=?
 * Константин=?
 * Иван=4
 * Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap,
 * если студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных,
 * если сохранено значение ?, заменить его на соответствующее число. Если на каком-то месте
 * встречается символ, отличный от числа или ?, бросить подходящее исключение.
 * Записать в тот же файл данные с замененными символами ?.
 */
public class Task_3 {
    private static final List<String> strings = List.of
            ("Анна=4", "Елена=5", "Марина=6", "Полина=?", "Владимир=?", "Константин=?", "Иван=4");
//для проверки, заменить какое-то из значений на null

    public static void main(String[] args) {
        writeFile(strings, "task3.txt");
        System.out.println(readFile("task3.txt"));
        rewrite("task3.txt");
    }


    public static void writeFile(List<String> list, String path) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);
            for (String s : list) {
                fw.write(s + "\n");
            }
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Map<String, Integer> readFile(String path) {
        BufferedReader br = null;
        Map<String, Integer> result = new HashMap<>();
        try {
            br = new BufferedReader(new FileReader(path));

            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("=");
                String key = split[0];
                int value = split[1].equals("?") ? key.length() : Integer.parseInt(split[1]);
                result.put(key, value);
//                int value;
//                try {
//                    value = Integer.parseInt(split[1]);
//                } catch (NumberFormatException e) {
//                    value = key.length();
//                }
            }

        } catch (NumberFormatException e) {
            throw new RuntimeException("Невалидные данные");
        } catch (IOException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public static void rewrite(String path) {
        Map<String, Integer> map = readFile(path);
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.toString());
        }
        writeFile(list, path);
    }



}