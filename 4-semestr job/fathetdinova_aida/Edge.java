package semestrovka;

public class Edge implements Comparable<Edge> {
	int v; 
	int w;  
	int weight;  
	
	public Edge()
	{
		this.v = 0;
		this.w = 0;
		this.weight = 0;
	}
	
	
	public Edge(int v,int w,int weight)
	{
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public Edge(int v,int w )
	{
		this.v = v;
		this.w = w;
		this.weight = 0;
	}
	
	
	
	public int weight()
	{return weight;}

	public int either()
	{return v;}
	
	public int other(int vert)
	{
		if(vert == v) return w;
		else if(vert == w) return v;
		else
		{
		System.out.println("Error");
		return 0;
		}
	}
	
	public int compareTo(Edge edge)
	{
		if(this.weight > edge.weight) return +1;
		else if(this.weight < edge.weight) return -1;
		else return 0;
	}

}
