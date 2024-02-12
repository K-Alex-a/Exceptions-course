package HW.lesson_03;

public class ArraySizeIzLargerException extends ArrayIndexOutOfBoundsException{
    public ArraySizeIzLargerException() {
        super("Размер массива превышает допустимый (6). Введены лишние данные!");
    }
}
