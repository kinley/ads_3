package semestrovka;

public class EdgeWeightedGraph {
	public final int V; 
	public int E;       
    public Bag<Edge>[] rebra;
    

    @SuppressWarnings("unchecked")
	public EdgeWeightedGraph(int V) {
        if (V < 0) throw new IllegalArgumentException(" оличество вершин не может быть отрицательным");
        this.V = V;
        this.E = 0;
        rebra = (Bag<Edge>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
        	rebra[v] = new Bag<Edge>();
        }
    }
    

    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("„исло вершин не может быть отрицательным");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            int weight = in.readInt();
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
        rebra[v].add(e);
        rebra[w].add(e);
        E++;
    }

  
    public Iterable<Edge> adj(int v) {
        if (v < 0 || v >= V) throw new IndexOutOfBoundsException("¬ершина не может быть отрицательной");
        return rebra[v];
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