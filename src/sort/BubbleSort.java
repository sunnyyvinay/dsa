package sort;

/*
 * Sample program for Bubble Sort algorithm
 *
 * https://www.geeksforgeeks.org/bubble-sort/
 *
 * Bubble Sort repeatedly swaps the adjacent elements if they are in wrong order. The algorithm stops when it goes through one pass
 * without any swaps.
 *
 * Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
 * In place algorithm
 * Stable algorithm
 */

public class BubbleSort {
    public static void main(String args[]) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        System.out.print("Unsorted array: ");
        printArray(arr);

        // lastUnsortedIndex goes right to left while i goes left to right based on the lastUnsortedIndex
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
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
