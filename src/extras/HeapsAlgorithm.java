package extras;

/*
 * Demonstration of Heaps Algorithm. This is used to generate all possible permutations of an array of n objects
 * https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/
 */

public class HeapsAlgorithm {
    public static void main(String[] args) {
        int a[] = {1, 2, 3};
        heapPermutation(a, a.length, a.length);
    }

    public static void heapPermutation(int a[], int size, int n) {
        // if size becomes 1 then prints the obtained permutation
        if (size == 1) {
            printArr(a, n);
        }
        for (int i = 0; i < size; i++) {
            heapPermutation(a, size - 1, n);

            // if size is odd, swap first and last element
            if (size % 2 == 1) {
                int temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }

            // If size is even, swap ith and last element
            else {
                int temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }
    }

    public static void printArr(int a[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
