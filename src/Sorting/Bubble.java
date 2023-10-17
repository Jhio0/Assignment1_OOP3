package Sorting;

import dev.GeometricShape;


public class Bubble {
	
	public static void bubbleSort(GeometricShape[] arr) {
		int n = arr.length;
	    boolean swapped;

	    for (int i = 0; i < n - 1; i++) {
	        swapped = false;

	        for (int j = 0; j < n - i - 1; j++) {
	            // Compare GeometricShape objects using the compareTo method
	            if (arr[j].compareTo(arr[j + 1]) > 0) {
	                GeometricShape temp = arr[j];
	                arr[j] = arr[j + 1];
	                arr[j + 1] = temp;
	                swapped = true;
	            }
	        }

	        if (!swapped) {
	            break; // If no elements were swapped, the array is sorted
	        }
	    }
	}
}
