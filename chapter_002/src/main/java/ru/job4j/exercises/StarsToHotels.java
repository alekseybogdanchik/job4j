package ru.job4j.exercises;


import java.util.*;

public class StarsToHotels {
    public List<Integer> addStars(List<Integer> ratingList, int n) {
        TreeSet<Integer> set = new TreeSet<>(ratingList);

        for (Integer h : set) {
            System.out.print(h);
        }
        System.out.println();

        int[] table = new int[101];
        int delta = n / 5;
        int rate = delta;
        for (Integer i : set) {
            table[i] = rate / delta;
            rate++;
            System.out.print(table[i]);
        }
        System.out.println();

        List<Integer> out = new ArrayList<>(ratingList.size());
        for (Integer i : ratingList) {
            System.out.print(i);
            out.add(table[i]);
        }
        return out;
    }
}