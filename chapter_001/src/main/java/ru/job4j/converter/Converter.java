package ru.job4j.converter;

public class Converter {

    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int euroToRuble(int value) {
        return value * 70;
    }

    public static int dollarToRuble(int value) {
        return value * 60;
    }

    public static void main(String[] args) {
        int euro = rubleToEuro(140);
        System.out.println("140 rubles are " + euro + " euro.");
        int euroIn = 140;
        int euroExpected = 2;
        int euroOut = rubleToEuro(euroIn);
        boolean passed1 = euroExpected == euroOut;
        System.out.println("Test. 140 rubles are 2 euro. Test result: " + passed1);

        int dollar = rubleToDollar(180);
        System.out.println("180 rubles are " + dollar + " dollars.");
        int dollarIn = 180;
        int dollarExpected = 3;
        int dollarOut = rubleToDollar(dollarIn);
        boolean passed2 = dollarExpected == dollarOut;
        System.out.println("Test. 180 rubles are 3 dollars. Test result: " + passed2);

        int eRuble = euroToRuble(560);
        System.out.println("560 euro are " + eRuble + " rubles.");
        int erubleIn = 560;
        int erubleExpected = 39200;
        int erubleOut = euroToRuble(erubleIn);
        boolean passed3 = erubleExpected == erubleOut;
        System.out.println("Test. 560 euro are 39200 rubles. Test result: " + passed3);

        int dolRuble = dollarToRuble(500);
        System.out.println("500 dollars are " + dolRuble + " rubles.");
        int dolRubleIn = 500;
        int dolRubleExpected = 30000;
        int dolRubleOut = dollarToRuble(dolRubleIn);
        boolean passed4 = dolRubleExpected == dolRubleOut;
        System.out.println("Test. 500 dollars are 30000 rubles. Test result: " + passed4);
    }
}
