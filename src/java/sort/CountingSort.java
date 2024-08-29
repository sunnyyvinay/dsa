package sort;

/*
 * Sample implementation of Counting Sort
 *
 * https://www.geeksforgeeks.org/counting-sort/
 *
 * Counting sort makes assumptions about the data. It doesn't use comparisons and only works with positive discrete values. The values
 * must be within a specific range. It counts the number of occurrences of each value.
 *
 * Not in place algorithm
 * O(n) because of the assumptions of the data we make
 * This algorithm is for small range data
 */

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};

        countingSort(arr, 1, 10);

        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void countingSort(int[] input, int min, int max) {
        int[] countArray = new int[(max-min) + 1];

        for (int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countArray[i-min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}
