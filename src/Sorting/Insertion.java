package Sorting;

import dev.GeometricShape;

public class Insertion {
	
	public static void insertionSort(GeometricShape[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            GeometricShape key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}
