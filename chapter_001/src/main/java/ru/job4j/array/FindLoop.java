package ru.job4j.array;

public class FindLoop {
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int index = start; index <= finish; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    public int[] sort(int[] data) {
        FindLoop find = new FindLoop();
        for (int i = 0; i < (data.length - 1); i++) {
            int min = MinDiapason.findMin(data, i, data.length);
            int indexMin = find.indexOf(data, min, i, data.length);
            int temp = data[i];
            data[i] = data[indexMin];
            data[indexMin] = temp;
        }
        return data;
    }
}
