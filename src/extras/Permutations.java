package extras;

/*
 * Demonstration of Generating Permutations using Recursion.
 * https://usaco.guide/CPH.pdf#page=59
 */

import java.io.IOException;
import java.util.ArrayList;

public class Permutations {
    static ArrayList<Integer> permutation;
    static boolean[] chosen;
    static int n;
    static int[] a;

    public static void main(String[] args) throws IOException {
        a = new int[]{1, 2, 3};
        n = 3;
        permutation = new ArrayList<>();
        chosen = new boolean[n];
        search();
    }

    private static void search() {
        if (permutation.size() == n) { // process permutation
            printArr(permutation, n);
        } else {
            for (int i = 0; i < n; i++) {
                if (chosen[i]) continue;
                chosen[i] = true;
                permutation.add(a[i]);
                search();
                chosen[i] = false;
                permutation.remove(permutation.size()-1);
            }
        }
    }

    public static void printArr(ArrayList<Integer> a, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(a.get(i) + " ");
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
