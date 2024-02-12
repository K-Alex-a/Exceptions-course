package HW.lesson_03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * 1. Напишите приложение, которое будет запрашивать у пользователя следующие данные,
 * разделенные пробелом в заданном порядке:
 * Фамилия Имя Отчество дата рождения номер телефона пол
 * Форматы данных:
 * фамилия, имя, отчество - строки
 * дата рождения - строка формата dd.mm.yyyy
 * номер телефона - целое беззнаковое число без форматирования
 * пол - символ латиницей f или m.
 * ------------------------------------------------------------------------
 * 2. Приложение должно проверить введенные данные по количеству.
 * Если количество не совпадает, вернуть код ошибки, обработать его и показать пользователю сообщение,
 * что он ввел меньше и больше данных, чем требуется.
 * ------------------------------------------------------------------------
 * 3. Приложение должно распарсить полученную строку и выделить из них требуемые значения.
 * Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
 * Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
 * пользователю выведено сообщение с информацией, что именно неверно.
 * ------------------------------------------------------------------------
 * 4. Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
 * в него в одну строку должны записаться полученные данные, вида
 * <Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>
 * ------------------------------------------------------------------------
 * 5. Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 * Не забудьте закрыть соединение с файлом.
 * ------------------------------------------------------------------------
 * 6. При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
 * пользователь должен увидеть стектрейс ошибки.
 */
public class Example {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Введите данные через пробел:
                Фамилия
                Имя
                Отчество
                Дата рождения (формат: дд.мм.гггг.)
                Номер телефона (от 6 до 10 цифр)
                Пол (ввести f или m)""");
        String next = scanner.nextLine();
        String[] data = next.split("\\s");

        CheckException exception = new CheckException();
        exception.checkFormatData(data);


        Human human = new Human(data);


        String fileName = data[0] + ".txt";
        writeFile(fileName, human);
        try {
//            readFile("Ddddd.txt");
            readFile(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Запись файла
     * @param fileName имя файла
     * @param human данные для записи в файл
     */
    public static void writeFile(String fileName, Human human) {
        try (FileWriter fw = new FileWriter(fileName, true)) { // открытие файла на дозапись с помощью true в конце
            fw.write(human + "\n");
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Чтение файла с выводом в консоль
     * @param fileName имя файла
     * @throws IOException исключение
     */
    public static void readFile(String fileName) throws IOException {
        try (FileReader fr = new FileReader(fileName)) {
            Scanner scan = new Scanner(fr);
            int i = 1;
            while (scan.hasNextLine()) {
                System.out.println(i + " : " + scan.nextLine());
                i++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл не найден");
        }
    }


}



