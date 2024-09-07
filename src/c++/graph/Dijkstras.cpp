#include <iostream>
#include <vector>
using namespace std;

vector<int> findPath(vector<vector<int>>& graph, int startNode);

/*
 * Dijkstra's ALGORITHM
 *
 * Finds the shortest path with the minimum weighted sum.
 * It calculates the path for every vertex from a given starting point.
 *
 * Time complexity: O(V^2 + E)
 *
 */

vector<int> findPath(vector<vector<int>>& graph, int startNode) {
    vector<int> distances(graph.size());
    vector<bool> visited(graph.size());
    for (int v = 0; v < graph.size(); v++) {
        distances[v] = INT_MAX;
        visited[v] = false;
    }
    distances[startNode] = 0;

    for (int j = 1; j < visited.size(); j++) {
        int u = 1;
        int minDist = INT_MAX;
        for (int i = 0; i < distances.size(); i++) {
            if (!visited[i] && distances[i] < minDist) {
                minDist = distances[i];
                u = i;
            }
        }

        visited[u] = true;
        for (int v = 0; v < graph[u].size(); v++) {
            distances[graph[u][v]] = min(distances[graph[u][v]], distances[u] + 1); // if weighted graph, replace 1 with weight(u, v)
        }
    }

    return distances;
}

int main() {
    vector<vector<int>> graph = {
            {1, 2}, // Node 0 is connected to nodes 1 and 2
            {0, 3}, // Node 1 is connected to nodes 0 and 3
            {0, 4}, // Node 2 is connected to nodes 0 and 4
            {1},    // Node 3 is connected to node 1
            {2}     // Node 4 is connected to node 2
    };

    findPath(graph, 0);
    cout << endl;

    return 0;
}