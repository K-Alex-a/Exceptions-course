package Seminars.lesson_03.Task_4;

public class MyArraySizeException extends NumberFormatException{

    public MyArraySizeException() {
        super("Некорректный размер массива");
    }
}
