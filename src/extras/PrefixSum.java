package extras;

/*
 * https://www.geeksforgeeks.org/prefix-sum-array-implementation-applications-competitive-programming/
 * https://www.geeksforgeeks.org/prefix-sum-2d-array/
 *
 * Demonstrates prefix sums in arrays
 *
 * Given an array arr[] of size n, its prefix sum array is another array prefixSum[] of same size such that the value
 * of prefixSum[i] is arr[0] + arr[1] + arr[2] + … + arr[i].
 *
 * The subarray sum between indices a and b in a 1-indexed array is prefix[b] - prefix[a-1].
 * The subarray sum between rows A and a and columns B and b in a 1-indexed 2D array is
 * prefix[A][B] - prefix[a-1][B] - prefix[A][b-1] + prefix[a-1][b-1]
 */

public class PrefixSum {
    public static void main(String[] args) {
        int arr[] = { 10, 4, 16, 20 };
        int n = arr.length;
        int prefixSum[] = new int[n+1];
        fillPrefixSum(arr, n, prefixSum);
        for (int i = 0; i < prefixSum.length; i++)
            System.out.print(prefixSum[i] + " ");
        System.out.println();
        System.out.println();

        int matrix[][] = {{1, 5, 6, 11, 8}, {1, 7, 11, 9, 4}, {4, 6, 1, 3, 2}, {7, 5, 4, 2, 3}};
        n = matrix.length;
        int m = matrix[0].length;
        int prefix2DSum[][] = new int[n+1][m+1];
        fill2DPrefixSum(matrix, prefix2DSum);
        for (int i = 0; i < prefix2DSum.length; i++) {
            for (int j = 0; j < prefix2DSum[i].length; j++)
                System.out.print(prefix2DSum[i][j] + " ");
            System.out.println();
        }
    }

    static void fillPrefixSum(int arr[], int n, int prefixSum[]) {
        prefixSum[0] = 0;

        for(int i = 1; i <= n; ++i) {
            prefixSum[i] = prefixSum[i-1] + arr[i-1];
        }
    }

    public static void fill2DPrefixSum(int a[][], int[][] psa) {
        int R = a.length;
        int C = a[0].length;

        for (int i = 0; i < psa.length; i++) {
            psa[0][i] = 0;
        }
        for (int i = 1; i < psa.length; i++) {
            psa[i][0] = 0;
        }

        // Filling first row and first column
        for (int i = 1; i <= C; i++)
            psa[1][i] = psa[1][i - 1] + a[0][i-1];
        for (int i = 1; i <= R; i++)
            psa[i][1] = psa[i - 1][1] + a[i-1][0];

        // updating the values in the cells as per the general formula.
        for (int i = 2; i <= R; i++) {
            for (int j = 2; j <= C; j++) {
                psa[i][j] = psa[i - 1][j] + psa[i][j - 1] - psa[i - 1][j - 1] + a[i-1][j-1];
            }
        }
    }
}
