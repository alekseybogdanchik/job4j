package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        for (int num = 2; num <= finish; num++) {
            count++;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}
