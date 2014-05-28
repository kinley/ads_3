import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class KruskalMST {
    private double weight;  // вес минимального остовного дерева
    private Queue<Edge> mst = new Queue<Edge>();  // ребра МОД
    public KruskalMST(EdgeWeightedGraph G) {
        MinPriorityQueue<Edge> pq = new MinPriorityQueue<Edge>(1);
        for (Edge e : G.edges()) {
            pq.insert(e);
        }
        UnionFind uf = new UnionFind(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin(); // извлечение из pq ребра с мин весом и его вершин
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) { // если v-w не создаст цикл
                uf.union(v, w);  // слияние v и w компонентов
                mst.enqueue(e);  // добавление ребра в mst
                weight += e.weight();
            }
        }
    }
    public Iterable<Edge> edges() {
        return mst;
    }
    public double weight() {
        return weight;
    }
    public static void main(String[] args) throws FileNotFoundException {
    	File file = new File("input.txt");
    	Scanner in;
    	try {
    		System.out.println("13");
    		in = new Scanner(file);
    		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
    		KruskalMST mst = new KruskalMST(G);
            for (Edge e : mst.edges()) {
                System.out.println(e);
            }
            System.out.printf("%.5f\n", mst.weight());
    	}catch (Exception e) {
    		System.out.println("File not found");
    		e.printStackTrace();
    	}
    }

}