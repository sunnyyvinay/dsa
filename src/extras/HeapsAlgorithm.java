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

/* Generating permutations and checking them in lexicographical order
static boolean[] used;
    static ArrayList<Integer> cur = new ArrayList<Integer>();
    static int n;
    static void gen() {
        if (cur.size() == n) {
            check(cur); // check current permutation for validity, or print it, etc.
            return;
        }
        for (int i = 0; i < n; ++i) if (!used[i]) {
            used[i] = true; cur.add(i+1);
            gen();
            used[i] = false; cur.remove(cur.size()-1);
        }
    }
    static void genPerm(int _n) {
        n = _n; used = new boolean[n];
        gen();
    }
    public static void main(String[] Args) {
        genPerm(5);
    }
 */
