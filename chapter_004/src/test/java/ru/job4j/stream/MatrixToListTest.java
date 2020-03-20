package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixToListTest {
    @Test
    public void convert() {
        MatrixToList mtl = new MatrixToList();
        Integer[][] matrix = {{1, 2}, {3, 4}};
        List<Integer> result = mtl.convert(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(expected, is(result));
    }
}