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
typedef pair<int, int> Pair; // 1 - distance, 2 - node
vector<int> findPath(vector<vector<Edge*>>& graph, int startNode);

/*
 * Dijkstra's ALGORITHM
 *
 * Finds the shortest path with the minimum weighted sum.
 * It calculates the path for every vertex from a given starting point.
 * This implementation uses a min-priority_queue based on the distance.
 *
 * Time complexity: O((m+n)log(n))
 *
 */

vector<int> findPath(vector<vector<Edge*>>& graph, int startNode) {
    vector<int> distances(graph.size(), INT_MAX);
    priority_queue<Pair, vector<Pair>, greater<Pair>> P;

    distances[startNode] = 0;
    P.push(make_pair(0, startNode));
    while (!P.empty()) {
        Pair curr = P.top();
        int currNode = curr.second;
        P.pop();
        for (Edge* neighbor : graph[curr.second]) {
            if (distances[currNode] + neighbor->weight < distances[neighbor->to]) {
                distances[neighbor->to] = distances[currNode] + neighbor->weight;
                P.push(make_pair(distances[neighbor->to], neighbor->to));
            }
        }
    }

    return distances;
}

int main() {
    vector<vector<Edge*>> graph = {
            {new Edge(1, 2), new Edge(2, 2)},                               // Node 0 is connected to nodes 1, 2
            {new Edge(0, 2), new Edge(4, 5), new Edge(3, 2)},    // Node 1 is connected to nodes 0, 3, 4
            {new Edge(0, 2), new Edge(4, 2)},                               // Node 2 is connected to nodes 0, 4
            {new Edge(1, 2), new Edge(4, 2)},                               // Node 3 is connected to node 1, 4
            {new Edge(1, 5), new Edge(3, 2), new Edge(2, 2)}     // Node 4 is connected to node 1, 2, 3
    };

    vector<int> d = findPath(graph, 0);
    for (int i : d) {
        cout << i << " ";
    }
    cout << endl;

    return 0;
}