#include <iostream>
#include <vector>
#include <queue>
using namespace std;

void bfs(vector<vector<int>>& graph, vector<bool> visited, int startNode);

/*
 * BREADTH FIRST SEARCH (DFS) ALGORITHM
 *
 * A graph traversal algorithm that explores all nodes at the present depth before moving on to nodes at the next depth level by using a queue
 *
 * Time complexity: O(V + E)
 *
 */

void bfs(vector<vector<int>>& graph, vector<bool> visited, int startNode) {
    queue<int> queue;

    queue.push(startNode);
    visited[startNode] = true;
    while (!queue.empty()) {
        int c = queue.front();
        queue.pop();
        cout << c << " ";
        for (int neighbor : graph[c]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.push(neighbor);
            }
        }
    }
}

int main() {
    vector<vector<int>> graph = {
            {1, 2}, // Node 0 is connected to nodes 1 and 2
            {0, 3}, // Node 1 is connected to nodes 0 and 3
            {0, 4}, // Node 2 is connected to nodes 0 and 4
            {1},    // Node 3 is connected to node 1
            {2}     // Node 4 is connected to node 2
    };
    vector<bool> visited(graph.size());

    bfs(graph, visited,0); // 0 1 2 3 4
    cout << endl;

    return 0;
}