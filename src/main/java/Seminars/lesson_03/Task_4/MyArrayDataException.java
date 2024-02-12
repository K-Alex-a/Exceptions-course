package Seminars.lesson_03.Task_4;

import java.util.List;

public class MyArrayDataException extends NumberFormatException{

    public MyArrayDataException(int i, int j) {
        super(String.format("В ячейке [%s][%s] не число", i, j));
    }

    public MyArrayDataException(List<NewPoint2D> point2DS) {
        super(String.format("В ячейках %s не числа", point2DS));
    }
}
