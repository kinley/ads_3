import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
	private int N; // количество элементов в очереди
	private Node first; // начало очереди
	private Node last; // конец очереди
	private class Node {
		private Item item;
		private Node next;
	}
	public Queue() {
		first = null;
		last = null;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public int size() {
		return N;
	}
	public Item peek() {
		// возвращает элемент, который был первым добавлен в очередь
		if (isEmpty()) throw new RuntimeException("Queue underflow");
		return first.item;
	}
	public void enqueue(Item item) {
		// добавление эл-та в конец оереди
		Node x = new Node();
		x.item = item;
		if (isEmpty()) {
			first = x;
			last = x;
		}
		else {
			last.next = x;
			last = x;
		}
		N++;
	}
	public Item dequeue() {
		//удаляет первый эл-т очереди
		if (isEmpty()) throw new RuntimeException("Queue underflow");
		Item item = first.item;
		first = first.next;
		N--;
		if (isEmpty()) last = null;
		return item;
	}
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext() {
			return current != null;
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
		public Item next() {
			if (!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}