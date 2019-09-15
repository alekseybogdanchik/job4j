package ru.job4j.array;

public class Defragment {
    public static String[] compress(String[] array) {
        for (int index = 0; index < array.length; index++) {
            String cell = array[index];
            if (cell == null) {
                // переместить первую не null ячейку
                // Здесь нужен цикл while
                int indexTemp = index;
                int indexFilled = index;
                String FilledCell = null;

                while (FilledCell == null && indexFilled < array.length-1) {
                    indexFilled++;
                    FilledCell = array[indexFilled];
                }

                array[indexTemp] = array [indexFilled];
                array [indexFilled] = null;

            }
            System.out.print(array[index] + " ");
        }
        return array;
    }
}
