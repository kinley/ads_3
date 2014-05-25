//сцепляемые очереди
public class MyQueue<Key extends Comparable<Key>, Value> {
	
	private ChainTree<Key, Value> tree = new ChainTree<>();
	
	public void put(Key key, Value val){
		tree.put(key, val);
	}
	
	public void show(String s){
		tree.show(s);
	}
	
	public MyQueue<Key, Value> insertAfter(Key key, MyQueue<Key, Value> insQueue, boolean fl){
		MyQueue<Key, Value> q = new MyQueue<>();
		ChainTree<Key, Value>[] trees = tree.divideBy(key, fl);		//делим на левое и правое поддерева
		ChainTree<Key,Value> leftTree = trees[0].concatenateWith(insQueue.tree);	//сцепляем левое с вставляемым
		if(fl)	leftTree.show("leftTree");
		q.tree = leftTree.concatenateWith(trees[1]);	//сцепляем получившееся с правым
		return q;
	}
}
