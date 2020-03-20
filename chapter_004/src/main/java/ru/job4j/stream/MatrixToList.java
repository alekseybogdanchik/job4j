package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {

    public List<Integer> convert(Integer[][] matrix) {
        List<Integer> list = Arrays.stream(matrix)
                .flatMap(e -> Stream.of(e))
                .collect(Collectors.toList());
        return list;
    }
}
