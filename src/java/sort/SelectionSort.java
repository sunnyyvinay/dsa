package sort;

/*
 * Sample program for Selection Sort algorithm
 *
 * https://www.geeksforgeeks.org/selection-sort/
 *
 * This algorithm partitions the array and repeatedly finds the largest value and swaps it to the sorted partition
 *
 * O(n^2) because of nested loops, not as much swapping as bubble sort though
 * In place algorithm
 * Unstable algorithm
 */

public class SelectionSort {
    public static void main(String args[]) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        System.out.print("Unsorted array: ");
        printArray(arr);

        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (arr[i] > arr[largest]) {
                    largest = i;
                }
            }
            swap(arr, largest, lastUnsortedIndex);
        }

        System.out.print("Sorted array: ");
        printArray(arr);
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}