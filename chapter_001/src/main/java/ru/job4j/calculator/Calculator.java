package ru.job4j.calculator;

/**
 * Класс Calculator выполняет арифметические действия
 * @author Bogdanchik
 * @since 07.09.19
 */

public class Calculator {
    /**
     * Сложение аргументов и вывод строки с выполняемым действием
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void add(double first, double second) {
        double result = first + second;
        System.out.println(first + " + " + second + " = " + result);
    }
    /**
     * Деление аргументов и вывод строки с выполняемым действием
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + " / " + second + " = " + result);
    }

    /**
     * Умножение аргументов и вывод строки с выполняемым действием
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void multiply(double first, double second) {
        double result = first * second;
        System.out.println(first + " * " + second + " = " + result);
    }

    /**
     * Вычитание аргументов и вывод строки с выполняемым действием
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void subtrack(double first, double second) {
        double result = first - second;
        System.out.println(first + " - " + second + " = " + result);
    }

    /**
     * Вызывает методы и передает аргументы
     * @param args
     */

        public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multiply(2, 1);
        subtrack(10, 5);
    }
}
