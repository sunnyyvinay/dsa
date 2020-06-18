package extras;

/*
 * https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/
 *
 * Demonstrates prefix sums in arrays
 *
 * Given an array arr[] of size n, its prefix sum array is another array prefixSum[] of same size such that the value
 * of prefixSum[i] is arr[0] + arr[1] + arr[2] … arr[i].
 */

public class PrefixSum {
    public static void main(String[] args) {
        int arr[] = { 10, 4, 16, 20 };
        int n = arr.length;
        int prefixSum[] = new int[n];

        fillPrefixSum(arr, n, prefixSum);

        for (int i = 0; i < n; i++)
            System.out.print(prefixSum[i] + " ");
        System.out.println("");
    }

    static void fillPrefixSum(int arr[], int n, int prefixSum[]) {
        prefixSum[0] = arr[0];

        for( int i = 1; i < n; ++i )
            prefixSum[i] = prefixSum[i-1] + arr[i];
    }
}
