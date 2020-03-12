package ru.job4j.exercises;


import java.util.Comparator;

public class HotelsAscByRating implements Comparator<Hotel> {
    @Override
    public int compare(Hotel o1, Hotel o2) {
        return Integer.compare(o1.getRating(), o2.getRating());
    }
}

