package ru.job4j.condition;

public class Point {
    public static double distance (int x1, int y1, int x2, int y2) {
        int x = x2-x1;
        int y = y2-y1;
        double first = Math.pow(x,2);
        double second = Math.pow(y,2);
        double formula = Math.sqrt(first+second);
        return formula;
    }

    public static void main(String[] args) {
        double result1 = distance(0, 0 , 2, 0);
        System.out.println("result (0, 0) to (0, 2) " + result1);
        double result2 = distance(1, 5 , 4, 5);
        System.out.println("result (1, 5) to (4, 5) " + result2);
        double result3 = distance(2, 6 , 4, 2);
        System.out.println("result (2, 6) to (4, 2) " + result3);
    }
}

























