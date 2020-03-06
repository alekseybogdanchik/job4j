package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        String[] leftDept = left.split("/");
        String[] rightDept = right.split("/");
        rsl = rightDept[0].compareTo(leftDept[0]);
            if (rsl == 0) {
                rsl = left.compareTo(right);
            }
        return rsl;
    }
}
