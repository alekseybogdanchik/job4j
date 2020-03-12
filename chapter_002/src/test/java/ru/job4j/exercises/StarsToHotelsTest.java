package ru.job4j.exercises;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StarsToHotelsTest {
    @Test
    public void test1() {
        int n = 5;
        List<Integer> ratingList = Arrays.asList(99, 2, 100, 50, 1);
        StarsToHotels add = new StarsToHotels();
        List<Integer> expected = Arrays.asList(4, 2, 5, 3, 1);
        assertThat(add.addStars(ratingList, n), is(expected));
    }

    @Test
    public void test2() {
        int n = 10;
        List<Integer> ratingList = Arrays.asList(100, 90, 10, 20, 50, 60, 40, 30, 80, 70);
        StarsToHotels add = new StarsToHotels();
        List<Integer> expected = Arrays.asList(5, 5, 1, 1, 3, 3, 2, 2, 4, 4);
        assertThat(add.addStars(ratingList, n), is(expected));
    }
}
