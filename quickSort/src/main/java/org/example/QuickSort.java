package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class QuickSort {
    // QuickSort method that returns a sorted array
    public static int[] quickSort(int[] arr) {
        if (arr == null) {
            throw new NullPointerException("Input array cannot be null");
        }
        
        
        if (arr.length == 0) {
            return arr; // Handle edge cases
        }
        // Clone the input array to avoid modifying the original array
        int[] sortedArr = arr.clone();
        quickSortHelper(sortedArr, 0, sortedArr.length - 1);
        return sortedArr;
    }

    // Helper method for performing the recursive QuickSort
    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortHelper(arr, low, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, high);
        }
    }

    // Partition method for QuickSort
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choosing the last element as the pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i + 1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return the index of the pivot
    }
}