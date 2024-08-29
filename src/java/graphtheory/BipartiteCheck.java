package graphtheory;

/*
 * Checks whether a graph is bipartite or not
 *
 * A bipartite graph is a graph such that each node can be colored in one of two colors, such that no two adjacent nodes have
 * the same color. A graph is bipartite IFF there are no cycles of odd length. We can use DFS/BFS to make this check by
 * coloring the starting node red, all of its neighbors blue, and so on. We keep checking previously visited nodes have
 * the correct color.
 *
 * You can check for anything regarding the graph coloring in the DFS check.
 */

import java.util.ArrayList;

public class BipartiteCheck {
    static ArrayList<Integer>[] adj; // Represent graph using Adjacency List
    static boolean[] visited; // which nodes we have visited
    static boolean[] colors; // which color each node is (1 or 0)

    static boolean bipartiteDFS(int node) {
        visited[node] = true;
        for(int next : adj[node]) { // goes through each of the current node's neighbors
            if (!visited[next]) {
                // color the adjacent nodes the opposite color
                colors[next] = !colors[node];
                bipartiteDFS(next);
            } else {
                // not bipartite because a previously colored adjacent node has the same color as the current node
                if (colors[node] == colors[next]) return false;
            }
        }

        return true;
    }
}
