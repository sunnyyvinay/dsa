package graphtheory;

/*
 * Disjoint Set Data Structure (DSU)
 *
 * DSU operates with a set partitioned in several disjoint subsets. It supports two basic operations: Merge two sets and
 * check if two sets are connected. DFS or BFS could always be used to do this but it is a lot slower. It is better to
 * use DSU instead of DFS when you are adding edges at execution time.
 *
 * This optimized implementation (path compression and storing heights of trees) runs at most O(logN)
 *
 * https://csacademy.com/lesson/disjoint_data_sets/
 */

public class DisjointSetUnion {
    static int[] parent; // stores the root of each set
    static int[] height; // stores heights of trees with specific roots

    static void initialize(int N) {
        for (int i = 0; i < N; i++) {
            parent[i] = i; // initially, the root of each set is the node itself
            height[i] = 0;
        }
    }

    static int find(int x) { // finds the root of the set of x
        if (parent[x] != x) { // if x is the parent of itself, it is the root
            // we set the direct parent to the root of the set to reduce path length (path compression optimization)
            parent[x] = find(parent[x]); // recurse to the parent of x
        }

        return parent[x];
    }

    static void union(int A, int B) { //merges the sets of a and b
        int rootA = find(A); // find the root of A
        int rootB = find(B); // find the root of B
        // Optimizes time complexity of DSU by choosing the root of the smaller tree to become the son of the other root
        if (height[rootA] > height[rootB]) {
            parent[rootB] = rootA;
            height[rootA] = Math.max(height[rootA], height[rootB] + 1);
        } else {
            parent[rootA] = rootB;
            height[rootB] = Math.max(height[rootB], height[rootA] + 1);
        }
    }

    /* TO FIND THE NUMBER OF CONNECTED COMPONENTS
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) ans++;
        }
    */
}
