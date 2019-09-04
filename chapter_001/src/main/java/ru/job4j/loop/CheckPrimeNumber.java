package ru.job4j.loop;

public class CheckPrimeNumber {
    public boolean check(int num) {
        boolean prime = false;
        if (num % num == 0 && num % 1 == 0) {
            prime = true;
        }
        for (int index = 2; index < num; index++) {
        if (num % index == 0) {
            prime = false;
            break;
            }
        }
        return prime;
    }
}
