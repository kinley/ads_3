package ru.kpfu.ivmiit.tree;

public class Task {
	public static void main(String[] args) {
		DTree tree = processFirstTree();
		writeInfo(tree);
	}

	public static DTree processFirstTree() {
		DTree tree = new DTree(10);
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
		tree.unite(1, 3);
		//  1   4    5     6    7    
	    //  |       /  \      /   \
		//  3      2    4    8     9
		tree.unite(1, 6);
	    //    1    4   5     6    7    
	    //   / \      /  \      /   \
		//  3   6    2    4    8     9
		tree.unite(6, 7);
        //	  1       4   5    6  
		//  / | \        /  \      
	    // 3  6  7      2    4 
		//      / \
		//	   8   9
		tree.unite(3, 6);
		//nothing
		
//		tree.depth(8);
		tree.merge(5,7);
//		tree.merge(1, 2);
		return tree;
	}

	public static void writeInfo(DTree tree) {
		System.out.println("Глубина вершин после слияния");
		for (int i = 1; i < 10; i++) {
			System.out.println(tree.depth[i]);
		}
	}
}
