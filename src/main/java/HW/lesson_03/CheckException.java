package HW.lesson_03;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CheckException {

    /**
     * Проверка формата данных
     *
     * @param arr массив, содержащий данные для проверки
     */
    public void checkFormatData(String[] arr) {
        try {
            checkLengthArray(arr);
            LocalDate.parse(reverseDate(arr));
            Long.parseLong(arr[4]);
            checkPhoneNumberLength(arr);
            checkGender(arr);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Некорректный ввод даты рождения.");
        } catch (NumberFormatException e) {
            throw new DataFormatException(4);
        }
    }

    /** Проверка количества введенных данных
     * @param arr массив с данными для проверки
     */
    private void checkLengthArray(String[] arr) {
        if (arr.length < 6) {
            throw new ArraySizeIsSmallerException();
        } else if (arr.length > 6) {
            throw new ArraySizeIzLargerException();
        }
    }

    /** Смена формата даты
     * Перевод строки с датой рождения из формата дд.мм.гггг к формату гггг-мм-дд
     *
     * @param arr массив, содержащий строку с датой рождения
     * @return строку с датой рождения в формате гггг-мм-дд
     */
    private String reverseDate(String[] arr) {
        String[] newDate = arr[3].split("\\.");
        for (int i = 0; i < newDate.length/2; i++) {
            String temp = newDate[i];
            newDate[i] = newDate[newDate.length - 1];
            newDate[newDate.length - 1] = temp;
        }
        String result = String.join("-", newDate);
        return result;
    }

    /**
     * Проверка номера телефона
     * на количество введенных цифр
     * @param arr массив, содержащий номер телефона
     */
    private void checkPhoneNumberLength(String[] arr) {
        int length = arr[4].length();
        if (length > 6 && length < 10) {
            return;
        } else {
            throw new RuntimeException("Некорректный ввод номера телефона");
        }
    }

    /**
     * Проверка пола
     * @param arr массив, содержащий информацию о поле
     */
    private void checkGender(String[] arr) {
        String gender = arr[5];
        if (gender.equals("f") || gender.equals("m")) {
        } else {
            throw new RuntimeException("Некорректный ввод пола.");
        }
    }

}
