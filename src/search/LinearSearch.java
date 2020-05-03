package search;

/*
 * Implementation of the Linear Search algorithm.
 *
 * Linear search just goes through the array and returns the index when found
 */

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {15, 5, 2, 1, 8, 9, 55, 34};
        System.out.println(linearSearch(arr, 1));
    }

    public static int linearSearch(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
