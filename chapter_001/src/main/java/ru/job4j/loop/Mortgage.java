package ru.job4j.loop;

public class Mortgage {
    public int year(int amount, int monthly, double percent) {
        int year = 0;
        int result = amount;
        int yearPays = monthly * 12;
        while (result > 0) {
            year++;
            result = (int) ((result + (result * (percent / 100))) - yearPays);
           }
        return year;
    }
}
