package graphs;

/*
 * Edge List way of representing graphs
 *
 * There is a single list of all edges in the form (a, b, w). It is usually used for weighted, undirected graphs
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class EdgeList {
    static int n, m; // number of nodes and edges
    static ArrayList<Edge> edges;
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        edges = new ArrayList<Edge>();
        for(int i = 0; i < m; i++){ // for each of the m edges
            st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, w)); // add the edge to the list
        }
        Collections.sort(edges);
    }

    static class Edge implements Comparable<Edge> {
        int a, b, w;
        public Edge(int a, int b, int w){
            this.a = a;
            this.b = b;
            this.w = w;
        }
        public int compareTo(Edge e){ // sort order ascending or descending by weight
            return Integer.compare(w, e.w);
        }
    }
}
