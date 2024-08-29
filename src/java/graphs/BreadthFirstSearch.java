package graphtheory;

/*
 * Breadth-first search (BFS) on graph
 *
 * BFS visits nodes in order of distance away from the starting node. First, it visits nodes 1 edge away, then nodes that are
 * 2 edges away, and so on. It is not recursive, so DFS is usually better to use. BFS is used for finding the distance
 * away from the starting node for all nodes in an unweighted graph.
 *
 * Time complexity: O(V + E) , where V is the number of vertices and E is the number of edges
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    static ArrayList<Integer>[] adj; // Represent graph using Adjacency List
    static int[] dist; // Represents distance from each node to starting node

    static void bfs(int k) {
        Arrays.fill(dist, -1); // fill distance array with -1's to denote that these nodes have not been processed yet
        Queue<Integer> q = new LinkedList<>();
        dist[k] = 0;
        q.add(k);
        while(!q.isEmpty()) {
            int v = q.poll();
            for(int e : adj[v]) {
                if(dist[e] == -1) {
                    dist[e] = dist[v] + 1;
                    q.add(e);
                }
            }
        }
    }
}
