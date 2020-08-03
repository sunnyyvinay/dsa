package graphtheory;

/*
 * Adjacency Matrix way of representing graphs
 *
 * There is a 2D array of size N x N (number of nodes). For each pair of indices (a, b), it stores if the nodes have an edge
 * between them (1) or if they don't (0). If the graph is weighted, it stores the edge weight.
 *
 * https://www.geeksforgeeks.org/graph-and-its-representations/
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AdjacencyMatrix {
    static int n, m; // number of nodes and edges
    static int[][] adj; // adjacency matrix
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken()); // reads in number of nodes
        m = Integer.parseInt(st.nextToken()); // reads in number of edges
        adj = new int[n][n];

        for (int i = 0; i < m; i++) { // read in each of the m edges
            st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adj[a][b] = 1; // or set equal to w if graph is weighted
            adj[b][a] = 1; // or set equal to w if graph is weighted
            // ignore above line if graph is directed
        }
    }
}
