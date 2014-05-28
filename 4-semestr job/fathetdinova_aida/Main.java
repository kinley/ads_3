package semestrovka;

public class Main {
	public static void main(String[] args) {
	        In in = new In("file.txt");
	        EdgeWeightedGraph G =  new EdgeWeightedGraph(in);
	        System.out.println("»сходный граф " );
	        System.out.println("перва€ вершина - втора€ вершина = вес ребра " );
	        for (Edge e : G.edges())
		        StdOut.println(e.v + " - " + e.w + " = " + e.weight + " " );
	        
	        StdOut.println();
	        
	        KruskalAVL mst = new KruskalAVL(G);
	        System.out.println("ћинимальное остовное дерево: " );
	        System.out.println("перва€ вершина - втора€ вершина = вес ребра " );
	        for (Edge e : mst.edges())
	       StdOut.println(e.v + " - " + e.w + " = " + e.weight + " " );
	       StdOut.println(mst.weight());
	    }
}