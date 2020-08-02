package graphs;

/*
 * Adjacency List way of representing graphs
 *
 * There is a array with length N (number of nodes) of array lists. Each list stores the neighbors of a node. These take up
 * O(N + M) space.
 *
 * https://www.geeksforgeeks.org/graph-and-its-representations/
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AdjacencyList {
    static int n, m; // number of nodes and edges
    static ArrayList<Integer>[] adj; // adjacency list
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken()); // reads in number of nodes
        m = Integer.parseInt(st.nextToken()); // reads in number of edges
        adj = new ArrayList[n]; // adjacency list
        // Java doesn't allow ArrayList<Integer>[n]

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>(); // initializes the ArrayLists
        }
        for (int i = 0; i < m; i++) { // reading in each of the m edges
            st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1; // we subtract 1 because our array is zero-indexed
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a); // omit this line if the graph is directed
        }
    }

    // Edge class needed if graph is weighted
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}
