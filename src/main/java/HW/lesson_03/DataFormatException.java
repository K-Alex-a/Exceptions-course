package HW.lesson_03;

public class DataFormatException extends NumberFormatException {

    public DataFormatException(int i) {
        super(String.format("В ячейке [%s] не число", i));
    }
}
