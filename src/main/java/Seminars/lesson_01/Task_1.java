package Seminars.lesson_01;

/**
 * Реализуйте метод, принимающий в качестве аргументов целочисленный массив
 * и некоторый допустимый минимум.
 * Если длина массива меньше некоторого заданного минимума,
 * метод возвращает -1, в качестве кода ошибки, иначе - длину массива.
 */
public class Task_1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int min = 10;
        System.out.println(checkArrayLength(array, min));


    }

    public static int checkArrayLength(int[] arr, int min) {
        if (arr.length < min) {
            return -1;
        }
        return arr.length;
    }

}
