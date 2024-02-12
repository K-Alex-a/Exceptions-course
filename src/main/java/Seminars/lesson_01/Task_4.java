package Seminars.lesson_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализуйте метод checkArray(Integer[] arr), принимающий в качестве аргумента целочисленный одномерный массив.
 * Метод должен пройтись по каждому элементу и проверить что он не равен null. Реализуйте следующую логику:
 * 1. Если в какой-то ячейке встретился null, то необходимо “оповестить” об этом пользователя
 * 2. Если null’ы встретились в нескольких ячейках, то идеально было бы все их “подсветить”
 */
public class Task_4 {
    public static void main(String[] args) {
        checkArray(new Integer[]{1, null, 2, 3, 5, 6, null});


    }

    public static void checkArray(Integer[] arr) {
        List<Integer> wrongIndexes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) wrongIndexes.add(i);
        }
        if (!wrongIndexes.isEmpty()) {
            System.out.printf("По индексам %s лежат null%n", wrongIndexes);
        } else {
            System.out.println("В массиве null значений нет");
        }
    }

}
