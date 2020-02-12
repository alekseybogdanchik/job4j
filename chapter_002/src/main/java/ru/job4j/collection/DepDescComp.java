package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int minLength = left.length() < right.length() ? left.length() : right.length();
        for (int index = 0; index < 2; index++) {
            rsl = Character.compare(right.charAt(index), left.charAt(index));
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0 && minLength == 2) {
            rsl = left.length() - right.length();
        }
        if (rsl == 0 && minLength != 2) {
            for (int index = 2; index < minLength; index++) {
                rsl = Character.compare(left.charAt(index), right.charAt(index));
                if (rsl != 0) {
                    break;
                }
            }
        }
        return rsl;
    }
}
