package ru.job4j.sort;

import java.util.Arrays;

public class Merge {
	public int[] merge(int[] left, int[] right) {
		int[] rsl = new int[left.length + right.length];
		int n = 0;
		int l = 0;
		int r = 0;
		while (n < rsl.length) {
			if (l == left.length) {
				rsl[n] = right[r];
				r++;
			} else if (r == right.length) {
				rsl[n] = left[l];
				l++;
			} else if (left[l] <= right[r]) {
				rsl[n] = left[l];
				l++;
			} else if (right[r] <= left[l]) {
				rsl[n] = right[r];
				r++;
			}
			n++;
		}
		return rsl;
	}

	public static void main(String[] args) {
		Merge process = new Merge();
		int[] rsl = process.merge(
				new int[] {2, 4, 6},
				new int[] {1, 3}
		);
		System.out.println(Arrays.toString(rsl));
	}
}
