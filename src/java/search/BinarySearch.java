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
 *
 * A sqrt function can be created using binary search. It has the same implementation as a regular search, but to have
 * precision, use the commented code at the bottom.
 */

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-22, -15, 1, 7, 20, 35, 55};

        System.out.println(iterativeBinarySearch(arr, -15));
        System.out.println(iterativeBinarySearch(arr, 35));
        System.out.println(iterativeBinarySearch(arr, 8888));
        System.out.println(iterativeBinarySearch(arr, 1));
    }

    public static int iterativeBinarySearch(int[] arr, int val) {
        int l = 0;
        int r = arr.length-1;

        while (l <= r) {
            int mid = l + ((r-l) / 2);
            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] < val) {
                l = mid + 1;
            } else if (arr[mid] > val) {
                r = mid - 1;
            }
        }

        return -1;
    }
}

/* For computing the fractional part of square root upto given precision
double increment = 0.1;
    for (int i = 0; i < precision; i++) {
        while (ans * ans <= number) {
            ans += increment;
        }

        // loop terminates when ans * ans > number
        ans = ans - increment;
        increment = increment / 10;
    }

    return (float) ans;
 */
