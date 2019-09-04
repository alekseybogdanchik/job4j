package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        for (int num = 2; num <= finish; num++) {
            if (num % num == 0 && num % 1 == 0) {
                count ++;
            }
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
