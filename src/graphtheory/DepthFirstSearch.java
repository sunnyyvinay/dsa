package graphtheory;

/*
 * Depth-first search (DFS) on graph
 *
 * DFS continues down a single path of nodes on a graph. When every node in the path has been visited, it backtracks to
 * nodes that have not been visited yet. The start is the zero-indexed number of the starting vertex.
 *
 * If you encounter stack overflows while using recursive DFS, you can write an iterative DFS, which is just BFS but
 * with nodes stored on a stack rather than a queue. Applications of DFS include connectivity check
 *
 * https://csacademy.com/lesson/depth_first_search/
 */

import java.util.ArrayList;

public class DepthFirstSearch {
    static ArrayList<Integer>[] adj; // Represent graph using Adjacency List
    static boolean[] visited; // which nodes we have visited

    // To find the number of nodes in a connected component, keep a count of the connected nodes
    static void dfs(int node) {
        //int visCount = 1;
        visited[node] = true;
        for(int next : adj[node]) { // goes through each of the current node's neighbors
            if(!visited[next]) {
                //visCount += dfs(next);
                dfs(next);
            }
        }

        //return visCount;
    }
}
