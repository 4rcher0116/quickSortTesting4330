package org.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class QuickSortTests {

    // Positive Test Cases 
    @Test
    void testQuickSortStandardInput() {
        int[] input = {5, 3, 8, 4, 2, 7, 1, 10};
        int[] expected = {1, 2, 3, 4, 5, 7, 8, 10};
        assertArrayEquals(expected, QuickSort.quickSort(input));
    }

    @Test
    void testQuickSortMixedNegativesAndPositives() {
        int[] input = {-10, 0, 5, -3, 8, 2};
        int[] expected = {-10, -3, 0, 2, 5, 8};
        assertArrayEquals(expected, QuickSort.quickSort(input));
    }

    // Negative Test Case
    @Test
    void testQuickSortWithNullInput() {
        assertThrows(NullPointerException.class, () -> QuickSort.quickSort(null));
    }

    // Performance Cases 

    @Test
    void testQuickSortLargeArrayPerformance() {
        int[] largeArray = new int[1000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = largeArray.length - i;
        }
        int[] expected = largeArray.clone();
        java.util.Arrays.sort(expected);
        assertArrayEquals(expected, QuickSort.quickSort(largeArray));
    }

    @Test
    void testQuickSortNearlySortedArrayPerformance() {
        int[] nearlySorted = new int[10000];
        for (int i = 0; i < 9999; i++) {
            nearlySorted[i] = i + 1;
        }
        nearlySorted[9998] = 9999;
        nearlySorted[9999] = 9998;

        int[] expected = nearlySorted.clone();
        java.util.Arrays.sort(expected);
        assertArrayEquals(expected, QuickSort.quickSort(nearlySorted));
    }

    @Test
    void testQuickSortReverseSortedArrayPerformance() {
        int[] reverseSorted = new int[1000];
        for (int i = 0; i < 1000; i++) {
            reverseSorted[i] = 1000 - i;
        }

        int[] expected = reverseSorted.clone();
        java.util.Arrays.sort(expected);
        assertArrayEquals(expected, QuickSort.quickSort(reverseSorted));
    }

    // Boundary Cases 
    @Test
    void testQuickSortEmptyArray() {
        int[] input = {};
        int[] expected = {};
        assertArrayEquals(expected, QuickSort.quickSort(input));
    }

    @Test
    void testQuickSortSingleElementArray() {
        int[] input = {7};
        int[] expected = {7};
        assertArrayEquals(expected, QuickSort.quickSort(input));
    }

    @Test
    void testQuickSortArrayWithDuplicates() {
        int[] input = {5, 1, 2, 1, 5, 3, 2};
        int[] expected = {1, 1, 2, 2, 3, 5, 5};
        assertArrayEquals(expected, QuickSort.quickSort(input));
    }

    @Test
    void testQuickSortArrayAllElementsSame() {
        int[] input = {4, 4, 4, 4, 4};
        int[] expected = {4, 4, 4, 4, 4};
        assertArrayEquals(expected, QuickSort.quickSort(input));
    }

    // Idempotency Cases 

    @Test
    void testQuickSortIdempotencyAlreadySorted() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};

        int[] sortedOnce = QuickSort.quickSort(input);
        int[] sortedTwice = QuickSort.quickSort(sortedOnce);

        assertArrayEquals(expected, sortedTwice);
    }
}
