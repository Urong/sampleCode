package com.younggambyeon.selection;

public class SelectionSort implements Sorter {

	@Override
	public int[] sort(int[] arr) {
		int size = arr.length;
		int selector = 1;

		for (int i = 0; i < size; i++) {
			int idx = 0;
			int tempValue = arr[i];

			for (int j = selector; j < size; j++) {
				int sub = arr[j];

				if (tempValue < sub) {
					idx = j;
					tempValue = sub;
				}
			}

			if (idx != 0) {
				tempValue = arr[i];
				arr[i] = arr[idx];
				arr[idx] = tempValue;
			}

			selector += 1;
		}

		return arr;
	}

	public static void main(String[] args) {
		String input = "73 44 66 71 80 92";

		String[] temp = input.split(" ");
		int[] arr = new int[temp.length];

		for (int i = 0; i < temp.length; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}

		Sorter selection = new SelectionSort();
		selection.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
