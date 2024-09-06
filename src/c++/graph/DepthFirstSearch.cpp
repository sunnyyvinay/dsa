#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int iterativeDFS(vector<vector<int>>& graph, int startNode);
int recursiveDFS(vector<vector<int>>& graph, vector<bool> visited, int startNode);

/*
 * DEPTH FIRST SEARCH DFS ALGORITHM
 *
 * A graph traversal algorithm which explores as far as possible along each branch before backtracking.
 * It models a stack to keep track of the nodes on the current search path either through recursion or the actual data structure.
 *
 * Time complexity: O(V + E)
 *
 */

int iterativeDFS(vector<vector<int>>& graph, int startNode) {
    vector<bool> visited(graph.size());
    stack<int> stack;

    stack.push(startNode);

    while (!stack.empty()) {
        int currNode = stack.top();
        stack.pop();

        if (!visited[currNode]) {
            visited[currNode] = true;
            cout << currNode << " ";

            for (int neighbor : graph[currNode]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}

int recursiveDFS(vector<vector<int>>& graph, vector<bool> visited, int startNode) {
    visited[startNode] = true;
    cout << startNode << " ";
    for (int neighbor : graph[startNode]) {
        if (!visited[neighbor]) {
            recursiveDFS(graph, visited, neighbor);
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

    iterativeDFS(graph, 0); // 0 2 4 1 1 3
    cout << endl;

    recursiveDFS(graph, visited,0); // 0 1 3 2 4
    cout << endl;

    return 0;
}