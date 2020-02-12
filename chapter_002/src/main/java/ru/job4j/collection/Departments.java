package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        HashSet<String> tmp = new HashSet<>();
        List<String> rsl = new ArrayList<>();
        for (String name : deps) {
            String start = "";
            for (String el : name.split("/")) {
                if (start.equals("")) {
                    tmp.add(el);
                    start = el;
                } else {
                    tmp.add(start + "/" + el);
                    start = start + "/" + el;
                }
            }
        }
        for (String uniq : tmp) {
            rsl.add(uniq);
        }
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}