import java.util.ArrayList;



public class Node {
	
	int val;
	Node left;
	Node right;
	int N; 
	
	int level;
	public int key;
	public int[] kortezh;

	
	public Node(int value, int N){
		this.val = value;
		this.N = N;
		this.left = null;
		this.right = null;
		this.key = -1;
	}

	
	public int getKey(){
		return key;
	}
	
}
