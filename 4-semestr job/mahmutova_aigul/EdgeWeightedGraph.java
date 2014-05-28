import java.util.Scanner;

public class EdgeWeightedGraph { // граф с взвешаннами вершинвми
    private final int V; // кол-во вершин
    private int E; // кол-во ребер
    private Bag<Edge>[] adj; // списки смежности
    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Edge>();
        }
    }
    public EdgeWeightedGraph(Scanner in) {
    	this(in.nextInt());
    	int E = in.nextInt();
    	for (int i = 0; i < E; i++) {
    		int v = in.nextInt();
    		int w = in.nextInt();
    		double weight = in.nextDouble();
    		Edge e = new Edge(v, w, weight);
    		addEdge(e);
    	}
    }
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
    public Iterable<Edge> adj(int v) {
        return adj[v];
    }
    public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }
}