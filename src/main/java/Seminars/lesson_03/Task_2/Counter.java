package Seminars.lesson_03.Task_2;

import java.io.IOException;

/**
 * Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение
 * внутренней int переменной на 1. Сделайте так, чтобы с объектом такого типа
 * можно было работать в блоке try-with-resources. Подумайте, что должно происходить
 * при закрытии этого ресурса? Напишите метод для проверки, закрыт ли ресурс.
 * При попытке вызвать add() у закрытого ресурса, должен выброситься IOException
 */
public class Counter implements AutoCloseable {

    boolean closed = false;
    int num = 0;

    public void add() throws IOException {
        num++;
        if (closed) {
            throw new IOException("Ресурс закрыт");
        }
    }

    @Override
    public void close() throws Exception {
        if (!closed) {
            closed = true;
        }
    }

    @Override
    public String toString() {
        return "num = " + num;
    }
}

class Main {
    public static void main(String[] args) {
//        Counter counter = new Counter();
//        try {
//            counter.add();
//            System.out.println(counter);
//            try {
//                counter.close();
//            } catch (Exception e) {
//                System.err.println(e.getMessage());
//            }
//            counter.add();
//
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
//
//
        try (Counter counter = new Counter()) {
            counter.add();
            System.out.println(counter);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
