package semestrovka;

public class main2 {
	public static void main(String[] args) {
	        In in = new In("file.txt");
	        EdgeWeightedGraph G =  new EdgeWeightedGraph(in);
	        System.out.println("�������� ���� " );
	        System.out.println("������ ������� - ������ ������� = ��� ����� " );
	        for (Edge e : G.edges())
		        StdOut.println(e.v + " - " + e.w + " = " + e.weight + " " );
	        
	        StdOut.println();
	        
	        Kruskal mst = new Kruskal(G);
	        System.out.println("����������� �������� ������: " );
	        System.out.println("������ ������� - ������ ������� = ��� ����� " );
	        for (Edge e : mst.edges())
	       StdOut.println(e.v + " - " + e.w + " = " + e.weight + " " );
	       StdOut.println(mst.weight());
	    }
}