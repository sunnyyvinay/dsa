package sort;

/*
 * Sample program for Insertion Sort algorithm
 *
 * https://www.geeksforgeeks.org/insertion-sort/
 *
 * Insertion Sort partitions the array and the sorted partition grows from left to right, while the unsorted values are being compared
 * to the sorted ones and inserted in their correct spot.
 *
 * Time complexity: O(n^2)
 * In place algorithm
 * Stable algorithm
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        System.out.print("Unsorted array: ");
        printArray(arr);

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];
            int i;

            for (i = firstUnsortedIndex; i > 0 && arr[i-1] > newElement; i--) {
                arr[i] = arr[i-1];
            }

            arr[i] = newElement;
        }

        System.out.print("Sorted array: ");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
