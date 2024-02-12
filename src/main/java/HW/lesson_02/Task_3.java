package HW.lesson_02;


/**
 * Напишите программу для выполнения арифметической операции деления двух целых чисел a и b.
 * При этом программа должна проверить, что делитель b не равен нулю, и выполнить
 * деление только в этом случае.
 * Если b равен нулю, программа должна вывести сообщение о невозможности выполнения
 * операции и вернуть результат равный нулю.
 * После выполнения операции деления, программа также должна вывести сумму чисел
 * a и b с помощью метода printSum.
 * Если аргументы не переданы через командную строку, используйте значения по умолчанию.
 * На входе:
 * '12'
 * '5'
 * На выходе:
 * 17
 * 2.4
 */
public class Task_3 {
    public static void main(String[] args) {
        int a;
        int b;

        if (args.length == 0) {
            a = 7;
            b = 0; // Default values if no arguments are provided
        } else {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
        }

        double result = Expr1.expr(a, b);
        System.out.println(result);
    }
}

class Expr1 {

    public static double expr(int a, int b) {
        // Введите свое решение ниже
        double c = 0;
        if ( b != 0) {
            c = (double) a / b;
            printSum(a, b);
        } else {
            printSum(a, b);
        }
        return c;

    }

    public static void printSum(int a, int b) {
        // Введите свое решение ниже
        System.out.println(a + b);
    }
}