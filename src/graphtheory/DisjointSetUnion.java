package graphtheory;

/*
 * Disjoint Set Data Structure (DSU)
 *
 * DSU operates with a set partitioned in several disjoint subsets. It supports two basic operations: Merge two sets and
 * check if two sets are connected. DFS or BFS could always be used to do this but it is a lot slower. It is better to
 * use DSU instead of DFS when you are adding edges at execution time.
 *
 * https://csacademy.com/lesson/disjoint_data_sets/
 */

public class DisjointSetUnion {
    static int[] parent; //stores the root of each set

    static void initialize(int N) {
        for (int i = 0; i < N; i++) {
            parent[i] = i; //initially, the root of each set is the node itself }
        }
    }

    static int find(int x) { //finds the root of the set of x
        if (x == parent[x]) { //if x is the parent of itself, it is the root
            return x;
        } else {
            // we set the direct parent to the root of the set to reduce path length (path compression optimization)
            return parent[x] = find(parent[x]); // recurse to the parent of x
        }
    }

    static void union(int a, int b) { //merges the sets of a and b
        int c = find(a); //find the root of a
        int d = find(b); //find the root of b
        if (c != d) {
            parent[d] = c; //merge the sets by setting the parent of d to c
        }
    }

    /* TO FIND THE NUMBER OF CONNECTED COMPONENTS
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) ans++;
        }
    */
}
