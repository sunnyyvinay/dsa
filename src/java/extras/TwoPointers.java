package extras;

/*
 * Demo of Two Pointers method
 *
 * This method iterates two monotonic pointers across an array to search for a pair of indices satisfying
 * some condition in linear time.
 * These are a few of the problems that can be solved using this technique.
 */

import java.util.*;

public class TwoPointers {
    public static void main(String[] args) {
        int[] arr = {1, 7, 11, 10, 5, 13};
        twoSum(arr, 15);

        arr = new int[] {6, 3, 6, 8, 2, 5};
        subarraySum(arr, 17);

        maxSubarraySum(arr);
    }

    // Find two elements in the array whose sum is equal to X
    public static void twoSum(int[] arr, int sum) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        while (left < right) {
            if (arr[left] + arr[right] == sum) {
                break;
            } else if (arr[left] + arr[right] < sum) {
                left++;
            } else {
                right--;
            }
        }
        if (left >= right) System.out.println("No answer exists");
        else System.out.println(left + " and " + right);
    }

    // Given an array of positive elements, find a contiguous subarray that sums to X
    public static void subarraySum(int[] arr, int x) {
        int left = 0;
        int right;
        int sum = 0;
        for (right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (sum > x && left < right) {
                sum -= arr[left];
                left++;
            }
            if (sum == x) {
                for (int i = left; i <= right; i++) {
                    System.out.print(arr[i] + " ");
                }
                break;
            }
        }
        if (sum != x) System.out.print("No answer exists");
        System.out.println();
    }

    // Finds the max sum of a subarray using Kadane's algorithm
    public static void maxSubarraySum(int[] arr) {
        int best = 0;
        int current = 0;
        for (int i = 0; i < arr.length; i++) {
            current = Math.max(0, current + arr[i]);
            best = Math.max(best, current);
        }
        System.out.println(best);
    }
}
