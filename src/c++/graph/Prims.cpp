#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Edge {
public:
    int weight = 0;
    int to = 0; // node

    Edge(int to, int weight) {
        this->weight = weight;
        this->to = to;
    }
};
typedef pair<int, int> Pair; // 1 - attachment cost, 2 - node
vector<vector<Edge*>> findMST(vector<vector<Edge*>>& graph, int startNode);

/*
 * Prim's ALGORITHM
 *
 * Finds the minimum spanning tree of a graph by adding edges with the minimum attachment cost to the MST.
 * This implementation uses a priority queue.
 *
 * Time complexity: O(m*log(n))
 *
*/

vector<vector<Edge*>> findMST(vector<vector<Edge*>>& graph, int startNode) {
    vector<int> A(graph.size(), INT_MAX);
    priority_queue<Pair, vector<Pair>, greater<Pair>> P; // min-heap
    vector<vector<Edge*>> T;
    for (int i = 0; i < graph.size(); i++) {
        T.push_back({});
    }
    vector<int> parent(graph.size());

    A[startNode] = 0;
    P.push(make_pair(0, startNode));
    while (!P.empty()) {
        Pair curr = P.top();
        int currNode = curr.second;
        int attachWeight = curr.first;
        P.pop();

        if (currNode != startNode) {
            T[parent[currNode]].push_back(new Edge(currNode, attachWeight));
            T[currNode].push_back(new Edge(parent[currNode], attachWeight));
        }

        for (Edge* neighbor : graph[currNode]) {
            if (T[neighbor->to].empty() && neighbor->weight < A[neighbor->to]) {
                A[neighbor->to] = neighbor->weight;
                P.push(make_pair(A[neighbor->to], neighbor->to));
                parent[neighbor->to] = currNode;
            }
        }
    }

    return T;
}

int main() {
    vector<vector<Edge*>> graph = {
            {new Edge(1, 2), new Edge(2, 2)},                               // Node 0 is connected to nodes 1, 2
            {new Edge(0, 2), new Edge(4, 5), new Edge(3, 2)},    // Node 1 is connected to nodes 0, 3, 4
            {new Edge(0, 2), new Edge(4, 2)},                               // Node 2 is connected to nodes 0, 4
            {new Edge(1, 2), new Edge(4, 2)},                               // Node 3 is connected to node 1, 4
            {new Edge(1, 5), new Edge(3, 2), new Edge(2, 2)}     // Node 4 is connected to node 1, 2, 3
    };

    vector<vector<Edge*>> T = findMST(graph, 0);

    return 0;
}