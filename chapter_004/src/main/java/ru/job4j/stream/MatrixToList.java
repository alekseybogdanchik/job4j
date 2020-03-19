package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {

    public static void main(String[] args) {

        Integer[][] matrix = {{1, 2}, {3, 4}};
        List<Integer> list = Arrays.stream(matrix).flatMap(e -> Stream.of(e)).collect(Collectors.toList());
        list.forEach(System.out::print);
    }
}
