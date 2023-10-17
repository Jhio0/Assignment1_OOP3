package Sorting;

import dev.GeometricShape;

public class Selection {
	public static void selectionSort(GeometricShape[] arr) {
		int n = arr.length;

	    for (int i = 0; i < n - 1; i++) {
	        // Find the minimum element in the unsorted part of the array
	        int minIndex = i;
	        for (int j = i + 1; j < n; j++) {
	            // Compare GeometricShape objects using the compareTo method
	            if (arr[j].compareTo(arr[minIndex]) < 0) {
	                minIndex = j;
	            }
	        }

	        // Swap the found minimum element with the element at index i
	        GeometricShape temp = arr[i];
	        arr[i] = arr[minIndex];
	        arr[minIndex] = temp;
	    }
	}
}
