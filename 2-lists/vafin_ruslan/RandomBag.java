import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;


public class RandomBag<Item> implements Iterable<Item> {
    private int N;
    private Node<Item> first;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    RandomBag() {
        first = null;
        N = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    
    public Iterator<Item> iterator()  {
    	Item[] array = (Item[]) new Object[N];
    	Node temp = first;
    	for(int i=0; i<N; i++){
    		array[i] = (Item) temp.item;
    		temp = temp.next;
    	}
    	ShuffleArray(array);
    	temp = first;
    	for(int i=0; i<N; i++){
    		temp.item = array[i];
    		temp = temp.next;
    	}
        return new ListIterator<Item>(first);  
    }
    
    private void ShuffleArray(Item[] array)
    {
        int index;
        Item temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }


	private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext(){ 
        	return current != null;     
        }
        
        public void remove(){
        	throw new UnsupportedOperationException();  
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

    public static void main(String[] args) {
        RandomBag<String> bag = new RandomBag<String>();
        String item = StdIn.readString();
        while (!item.equals("q")) {
            bag.add(item);
        	item = StdIn.readString();
        }

        StdOut.println("size of bag = " + bag.size());
        for(int i=0; i<5; i++){
        	for (String s : bag) {
            	StdOut.print(s + " ");
        	}
        	StdOut.println();
        }
    }
}
