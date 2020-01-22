package ru.job4j.sort;

import java.util.Arrays;

public class Machine {
    private static final int[] COINS = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int result = money - price;
        for (int coin : COINS) {
            while ((result - coin) >= 0) {
                rsl[size] = coin;
                size++;
                result = result - coin;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}
