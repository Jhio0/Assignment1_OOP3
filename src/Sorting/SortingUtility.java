package Sorting;

import java.util.Random;

import dev.GeometricShape;

public class SortingUtility {
	/*selection sort*/
	public static <T extends Comparable<T>> void selectionSort(T[] arr) {
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
	        T temp = arr[i];
	        arr[i] = arr[minIndex];
	        arr[minIndex] = temp;
	    }
    }
	/*bubble sort*/

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
    	int n = arr.length;
	    boolean swapped;

	    for (int i = 0; i < n - 1; i++) {
	        swapped = false;

	        for (int j = 0; j < n - i - 1; j++) {
	            // Compare GeometricShape objects using the compareTo method
	            if (arr[j].compareTo(arr[j + 1]) > 0) {
	                T temp = arr[j];
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
    /*insertion sort*/
    public static <T extends Comparable<T>> void insertionSort(T[] arr) {
    	int n = arr.length;
        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
    /*quick sort*/

    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
    	if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        // Randomly select a pivot element within the range [low, high]
        int randomPivotIndex = new Random().nextInt(high - low + 1) + low;
        T pivot = arr[randomPivotIndex];
        // Swap the pivot with the last element to apply the same partition logic
        arr[randomPivotIndex] = arr[high];
        arr[high] = pivot;

        int i = low - 1;
        for (int j = low; j < high; j++) {
            // Compare objects using the compareTo method
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    
    /*merger sort*/
    @SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> T[] mergeSort(T[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return arr; // Already sorted
        }

        // Split the array into two halves
        int mid = n / 2;
        T[] left = (T[]) new Comparable[mid];
        T[] right = (T[]) new Comparable[n - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, n - mid);

        // Recursively sort the two halves
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge the two sorted halves
        return merge(arr, left, right);
    }

    public static <T extends Comparable<T>> T[] merge(T[] arr, T[] left, T[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0, j = 0, k = 0;

        // Merge the two sorted arrays
        while (i < leftLength && j < rightLength) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy any remaining elements from both arrays (if any)
        while (i < leftLength) {
            arr[k++] = left[i++];
        }
        while (j < rightLength) {
            arr[k++] = right[j++];
        }

        return arr;
    }
    
    
    /*heap sort*/
    public static <T extends Comparable<T>> void heapSort(T[] arr) {
        int n = arr.length;

        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (maximum element) with the last element
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            
            heapify(arr, i, 0);
        }
    }

    private static <T extends Comparable<T>> void heapify(T[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Compare left child with the largest
        if (left < n && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }

        // Compare right child with the largest
        if (right < n && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }

        // If the largest is not the root
        if (largest != i) {
            // Swap the largest with the root
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
    
}
