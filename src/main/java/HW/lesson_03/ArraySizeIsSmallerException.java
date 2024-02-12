package HW.lesson_03;

public class ArraySizeIsSmallerException extends ArrayIndexOutOfBoundsException{

    public ArraySizeIsSmallerException() {
        super("Размер массива меньше допустимого (6). Данных не достаточно!");
    }
}
