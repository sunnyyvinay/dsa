package sort;

/*
 * Sample program for Shell Sort algorithm
 *
 * https://www.geeksforgeeks.org/shell-sort/
 *
 * This is a variation of Insertion Sort. Shell sort starts out using a larger gap value than 1. The gap is slowly reduced. The goal is
 * to reduce the amount of shifting required.
 *
 * Time complexity: O(n^2) is the worst case but it can perform much better
 * In place algorithm
 * Unstable algorithm
 */

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        System.out.print("Unsorted array: ");
        printArray(arr);

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int newElement = arr[i];
                int j = i;

                while (j >= gap && arr[j-gap] > newElement) {
                    arr[j] = arr[j-gap];
                    j -= gap;
                }

                arr[j] = newElement;
            }
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
