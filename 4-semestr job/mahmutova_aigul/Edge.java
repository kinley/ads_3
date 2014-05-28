public class Edge implements Comparable<Edge> { 

    private final int v; // одна вершина
    private final int w; // другая вершина
    private final double weight; // вес ребра
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double weight() {
        return weight;
    }
    public int either() {
        return v;
    }
    public int other(int vertex) {
        if      (vertex == v) return w;
        else if (vertex == w) return v;
       else {
    	   System.out.println("недопустимое ребро");
    	   return -1;
       }
    }
    public int compareTo(Edge that) {
        if      (this.weight() < that.weight()) return -1;
        else if (this.weight() > that.weight()) return +1;
        else                                    return  0;
    }
    public String toString() {
        return String.format("%d-%d %.5f", v, w, weight);
    }
}