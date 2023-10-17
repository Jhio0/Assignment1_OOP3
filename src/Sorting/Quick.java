package Sorting;

import java.util.Random;
import dev.GeometricShape;

public class Quick {
	public static void quickSort(GeometricShape[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(GeometricShape[] arr, int low, int high) {
        // Randomly select a pivot element within the range [low, high]
        int randomPivotIndex = new Random().nextInt(high - low + 1) + low;
        GeometricShape pivot = arr[randomPivotIndex];
        // Swap the pivot with the last element to apply the same partition logic
        arr[randomPivotIndex] = arr[high];
        arr[high] = pivot;

        int i = low - 1;
        for (int j = low; j < high; j++) {
            // Compare GeometricShape objects using the compareTo method
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                GeometricShape temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        GeometricShape temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}