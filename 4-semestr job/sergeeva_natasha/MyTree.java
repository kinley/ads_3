import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;



public class MyTree {
	
	Node root;
	
	
	public int size(){
		return size(root);
	}
		
	private int size(Node x){
		if (x == null) return 0;
		return x.N;
	}
		
	
	public void put(int val){
		root = put(root, val);
	}
		
	private Node put(Node x, int val){
		if (x == null)  return new Node(val, 1);

			if (val < x.val) 
						x.left = put(x.left, val);
			else if (val > x.val) 
						x.right = put(x.right, val);
			else 		x.val = val;
			
			x.N = size(x.left) + size(x.right) + 1;
			return x;
		}
		
	
	public int Depth(){
		return this.Depth(root);
	}
	
	private int Depth(Node node){

		int depthLeft, depthRight, depthval;

		  if (node == null)
		    depthval = 0;
		  else
		  {
		    depthLeft = Depth(node.left);
		    depthRight = Depth(node.right);
		    if (depthLeft > depthRight) depthval = 1 + depthLeft;
		    else depthval = 1 + depthRight;
		  }
		  return depthval;
	}
	
	
	
	// приписывем 0 всем листьям
	
	public void putKeyToLists(){
		Stack<Node> rights = new Stack<Node>();
		Stack<Node> lefts = new Stack<Node>();
		Node temp = root;
		
		
		if (temp.right != null)
		{
		rights.add(temp.right);
		while (!rights.isEmpty()){
			if (temp.left != null)
			{
				if (temp.right != null)
					rights.push(temp.right);
				temp = temp.left;
			}
			else
			{
				if (temp.right != null)
					rights.push(temp.right);
				else
					temp.key = 0;
				temp = rights.pop();
			}
		}
		}
	
		else if(temp.left != null)
		{
			lefts.add(temp.left);
			while (!lefts.isEmpty()){
				if (temp.right != null)
				{
					if (temp.left != null)
						lefts.push(temp.left);
					temp = temp.right;
				}
				else
				{
					if (temp.left != null)
						lefts.push(temp.left);
					else
						temp.key = 0;
					temp = lefts.pop();
				}
			}
		}
			
	}
		
		

	
	//приписываем уровни
	
	public void writeLevels(){
		Stack<Node> rights = new Stack<Node>();
		Stack<Node> lefts = new Stack<Node>();
		
		int depth = Depth(root);
		root.level = depth - 1;
		Node temp = root;
		
		if (temp.right != null)
			{
			rights.add(temp.right);
			while (!rights.isEmpty()){
				
				if (temp.right != null)
				{
					temp.right.level = temp.level-1;
					rights.push(temp.right);
				}
				
				if (temp.left != null)
				{
					temp.left.level = temp.level - 1;	
					temp = temp.left;
				}
				else
					temp = rights.pop();

			}
			}
		
		else if(temp.left != null)
		{
			lefts.add(temp.left);
			while (!lefts.isEmpty()){
				
				if (temp.left != null)
				{
					temp.left.level = temp.level-1;
					lefts.push(temp.left);
				}
				
				if (temp.right != null)
				{
					temp.right.level = temp.level - 1;	
					temp = temp.right;
				}
				else
					temp = lefts.pop();
			}
		}
		
		
	}
	
	
	
	public ArrayList<Node> LL(int i){
		int depth = Depth(root);
		if (i < 0 || i >= depth) return null;
		
		ArrayList<Node> queue = new ArrayList<Node>();
		ArrayList<Node> L = new ArrayList<Node>();
		Node temp = root;
		if (i == depth-1) {
			L.add(root);
			return L;
		}
		
		while (temp.level != i){	
        	if (temp.left!=null) queue.add(temp.left);
            if (temp.right!=null) queue.add(temp.right);
            if (!queue.isEmpty())
            	temp=queue.remove(0);
        }
		
		
		ArrayList<Node> sortedQueue = new ArrayList<Node>();
		
		queue.add(0, temp);
		int n = queue.size();
		
		for(int k = 0; k < n  || k < 4; k++){
			for (int j = 0; j < queue.size(); j++){
            	if(queue.get(j).key == k)
            		{
            		sortedQueue.add(queue.get(j));
            			queue.remove(j);
            			j--; 
            		}
            }
		}
		
		
		for(int j = 0; j < sortedQueue.size(); j++)
				L.add(sortedQueue.get(j));
		         	
		return L;
	}
	
	
	
	
	public Vector<int[]> SetKortezhs(int i, ArrayList<Node> L){
		
		Vector<int[]> S = new Vector<int[]>();
		ArrayList<Node> queue = new ArrayList<Node>();
		
		Node temp = root;
		if (i != Depth(root) - 1) 
			
			while (temp.level != i){
	        	if (temp.left!=null) queue.add(temp.left);
	            if (temp.right!=null) queue.add(temp.right);
	            if (!queue.isEmpty()) 
	            	temp=queue.remove(0);
	        }		
		
		while (temp.key == 0)
			temp = queue.remove(0);

		int k = 0, n = 0;;
	
		for(int j = 0; j < L.size() ; j++){ 
		{		
			if (temp.left != null)		n++;
			if (temp.right != null)		n++;
			if (n > 0){
				temp.kortezh = new int[n];
				for(k = 0; k < n; k++)
					{	temp.kortezh[k] = L.get(j).key; 
						j++;
					}
				j--;
				S.add(temp.kortezh);
		
			}
			if (!queue.isEmpty())  
				temp = queue.remove(0);
			n = 0;
	}

		}
		
		return S;
	}

	
	
	public void putKeyToNotLists(int i, Vector<int[]> S){
		
		ArrayList<Node> queue = new ArrayList<Node>();
		Node temp = root;
		
		// спускаемся до уровня i
		if (i != Depth(root) - 1) 
			
			while (temp.level != i){
	        	if (temp.left!=null) queue.add(temp.left);
	            if (temp.right!=null) queue.add(temp.right);
	            if (!queue.isEmpty()) 
	            	temp=queue.remove(0);
	        }		
		
		// пропускаем листы
		while (temp.left == null && temp.right == null)
			temp = queue.remove(0);
		

		int s = 1;
		boolean b = false;
		
		for (int k = 0; k < S.size(); k++){
						
			int j = 0;
			do{
				if (temp.key == -1)	// проверка на соотвествие этого кортежа данному узлу
					if (temp.kortezh.length == S.get(k).length)
						{
				
						for(int jj = 0; jj < temp.kortezh.length; jj++)
							if(temp.kortezh[jj] == S.get(k)[jj])
								b= true;
						
						if (b == true) 
							temp.key = s;
						}
				b = false;
			
				if (!queue.isEmpty()) 
					temp = queue.get(j);
				j++;
			
			} while(j < queue.size());
			
			
			int maxKey = 0;
			for(j = 0; j < queue.size(); j++)		
			{
				temp = queue.get(j);
				if (temp.key > maxKey)
					maxKey = temp.key;
			}
			
			s = maxKey + 1;
		}
		
		}
	
	    
	public void show(){
		ArrayList<Node> queue = new ArrayList<Node>();
		Node temp = root;
		System.out.print(temp.val + " ");
        do{
            	if (temp.left != null) 
            				queue.add(temp.left);
                if (temp.right != null) 
                			queue.add(temp.right);
                if (!queue.isEmpty()) {
                	if (temp.level != queue.get(0).level)
                		System.out.println();
                	
                temp=queue.remove(0);
                System.out.print(temp.val + " ");
            }
         
        }while (!queue.isEmpty() || temp.left!=null || temp.right!=null);
        System.out.println("\n\n");
	}
	
	public void showKeys(){
		ArrayList<Node> queue = new ArrayList<Node>();
		Node temp = root;
		System.out.print(temp.key + " ");
        do{
            	if (temp.left != null) 
            				queue.add(temp.left);
                if (temp.right != null) 
                			queue.add(temp.right);
                if (!queue.isEmpty()) {
                	if (temp.level != queue.get(0).level)
                		System.out.println();
                	
                temp=queue.remove(0);
                System.out.print(temp.key + " ");
            }
         
        }while (!queue.isEmpty() || temp.left!=null || temp.right!=null);
	
        System.out.println("\n\n");
	}
	
	
	public void showLevels(){
		ArrayList<Node> queue = new ArrayList<Node>();
		Node temp = root;
		System.out.print(temp.level + " ");
        do{
            	if (temp.left != null) 
            				queue.add(temp.left);
                if (temp.right != null) 
                			queue.add(temp.right);
                if (!queue.isEmpty()) {
                	if (temp.level != queue.get(0).level)
                		System.out.println();
                	
                temp=queue.remove(0);
                System.out.print(temp.level + " ");
            }
         
        }while (!queue.isEmpty() || temp.left!=null || temp.right!=null);
	
        System.out.println("\n\n");
	}
}
