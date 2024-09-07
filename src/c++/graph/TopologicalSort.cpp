#include <iostream>
#include <vector>
#include <stack>
using namespace std;

void topologicalSortUtil(int v, vector<vector<int>>& adj, vector<bool>& visited, stack<int>& Stack) {
    visited[v] = true;

    for (int i : adj[v]) {
        if (!visited[i]) topologicalSortUtil(i, adj, visited, Stack);
    }

    // Push current vertex to stack which stores the result
    Stack.push(v);
}

void topologicalSort(vector<vector<int>>& adj, int V) {
    stack<int> Stack;
    vector<bool> visited(V, false);

    for (int i = 0; i < V; i++) {
        if (!visited[i]) topologicalSortUtil(i, adj, visited, Stack);
    }

    while (!Stack.empty()) {
        cout << Stack.top() << " ";
        Stack.pop();
    }
}

int main() {
    int V = 4; // number of nodes

    vector<vector<int>> edges = { { 0, 1 }, { 1, 2 }, { 3, 1 }, { 3, 2 } };
    vector<vector<int> > adj(V);

    for (auto i : edges) {
        adj[i[0]].push_back(i[1]);
    }

    cout << "Topological sorting of the graph: ";
    topologicalSort(adj, V);
    cout << endl;

    return 0;
}