package search;

/*
 * Implementation of Binary Search algorithm
 *
 * Before using binary search, the array must be sorted! This algorithm chooses the element in the middle of the array and compares
 * it against the search value. If element is equal to the value, we're done. If element is greater than the value, search the left
 * half of the array. If the element is less than the value, search the right half of the array. This can happen because the data is
 * sorted already.
 *
 * This can be implemented recursively or iteratively
 * O(log n) time complexity - keeps dividing the array in half
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-22, -15, 1, 7, 20, 35, 55};

        /*
        System.out.println(iterativeBinarySearch(arr, -15));
        System.out.println(iterativeBinarySearch(arr, 35));
        System.out.println(iterativeBinarySearch(arr, 8888));
        System.out.println(iterativeBinarySearch(arr, 1));
        */

        System.out.println(recursiveBinarySearch(arr, -15));
        System.out.println(recursiveBinarySearch(arr, 35));
        System.out.println(recursiveBinarySearch(arr, 8888));
        System.out.println(recursiveBinarySearch(arr, 1));
    }

    public static int iterativeBinarySearch(int[] arr, int val) {
        int start = 0;
        int end = arr.length;

        while (start < end) {
            int midpoint = (start + end) / 2;
            if (arr[midpoint] == val) {
                return midpoint;
            } else if (arr[midpoint] < val) { // search right part of array
                start = midpoint + 1;
            } else { // search left part of array
                end = midpoint;
            }
        }

        return -1;
    }

    public static int recursiveBinarySearch(int[] arr, int val) {
        return recursiveBinarySearch(arr, 0, arr.length, val);
    }

    public static int recursiveBinarySearch(int[] arr, int start, int end, int val) {
        if (start >= end) {
            return -1;
        }

        int midpoint = (start + end) / 2;

        if (arr[midpoint] == val) {
            return midpoint;
        } else if (arr[midpoint] < val) {
            return recursiveBinarySearch(arr, midpoint + 1, end, val);
        } else {
            return recursiveBinarySearch(arr, start, midpoint, val);
        }
    }
}
