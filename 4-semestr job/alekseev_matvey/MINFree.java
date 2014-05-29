import java.io.IOException;


public class MINFree {
	public static MyTree processFirstTree() {
		MyTree tree = new MyTree(10);
		tree.makeSet(1);
		tree.makeSet(2);
		tree.makeSet(3);
		tree.makeSet(4);
		tree.makeSet(5);
		tree.makeSet(6);
		tree.makeSet(7);
		tree.makeSet(8);
		tree.makeSet(9);
		//1 2 3 4 5 6 7 8 9
		tree.unite(7, 8);
		//1 2 3 4 5 6 7 9
		//            |
		//            8
		tree.unite(7, 9);
		//1 2 3 4 5 6   7    
		//            /   \
		//           8     9
		tree.unite(5, 2);
		//1   3 4 5  6   7    
	    //        |     /   \
		//        2    8     9
		tree.unite(5, 4);
		//1   3 4    5     6   7    
	    //         /  \      /   \
		//        2    4    8     9
		//tree.unite(1, 3);
		//  1   4    5     6    7    
	    //  |       /  \      /   \
		//  3      2    4    8     9
		//tree.unite(1, 6);
	    //    1    4   5     6    7    
	    //   / \      /  \      /   \
		//  3   6    2    4    8     9
		//tree.unite(6, 7);
        //	  1       4   5    6  
		//  / | \        /  \      
	    // 3  6  7      2    4 
		//      / \
		//	   8   9
		//tree.unite(3, 6);
		return tree;
	}

	public static void main(String[] args) throws IOException 
	{
		MyTree tree = processFirstTree();
		MyTree tree1 = new MyTree(10);
		int[] pred=new int[11];
		int[] sled=new int[11];
		
		for (int i=1;i<11;i++)
		{
			pred[i]=i-1;
		}
		
		for (int i=0;i<10;i++)
		{
			sled[i]=i+1;
		}
		int k=8;
		for (int i=1;i<k;i++)
		{
			int j=tree.find(i);
			if (j<k)
			{
				System.out.println(i+" удаляется " +j+"-ой операций Извлечь_MIN");
				tree.unite(j, sled[j]);
				sled[pred[j]]=sled[j];
				pred[sled[j]]=pred[j];
				
			}
		}

	}

}
