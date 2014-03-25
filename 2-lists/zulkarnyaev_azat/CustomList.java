package ru.kpfu.ivmiit.apa;


import java.util.Iterator;

public class CustomList<T>  implements Iterable<T>{
	private int size;
	private Node<T> head;
	private Node<T> tail;
	
	public T getHead() {
		return head.getValue();
	}

	public void add(T node){
		Node<T> buf=tail;
		tail=new Node<>(node);
		tail.setNext(null);
		tail.setPrev(buf);
		if(isEmpty()){
			head=tail;
		}else{
			buf.setNext(tail);
		}
		size++;
		
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	public T get(int index){
		int i=0;
		Node<T> node=head;
		while(i<index){
			try{
				node=node.getNext();
				i++;
			}catch(NullPointerException e){
				System.out.println(e);
			}
		}
		return node.getValue(); 
	}
	private Node<T> getNode(int index){
		int i=0;
		Node<T> node=head;
		while(i<index){
			try{
				node=node.getNext();
				i++;
			}catch(NullPointerException e){
				System.out.println(e);
			}
		}
		return node; 
	}
	public void set(int index, T value){
		int i=0;
		Node<T> node=head;
		while(i<index){
			try{
				node=node.getNext();
				i++;
			}catch(NullPointerException e){
				System.out.println(e);
			}
		}
		node.setValue(value);
	}
	public void swap(int index1, int index2){
		Node<T> first=getNode(index1);
		Node<T> second=getNode(index2);
		T buf=first.getValue();
		first.setValue(second.getValue());
		second.setValue(buf);
	}

	public void removeElement(int index) {
		Node<T> node=getNode(index);
		Node<T> prev = node.getPrev();
		prev.setNext(node.getNext());
		size--;
	}
	@Override
	public String toString() {
		Iterator<T> iterator = new CustomIterator();
		String result="";
		while(iterator.hasNext()){
			result=result+iterator.next()+", ";
		}
		return result;
	}
	@Override
	public Iterator<T> iterator() {
		return new CustomIterator();
	}
	public Iterator<T> iterator(int index) {
		return new CustomIterator(index);
	}
	private class CustomIterator implements Iterator<T>{
		int cursor;

		@Override
		public boolean hasNext() {
			return cursor<size;
		}
		public CustomIterator() {
			cursor=0;
		}
		public CustomIterator(int index){
			cursor=index;
		}
		@Override
		public T next() {	
			return  get(cursor++);
		}

		@Override
		public void remove() {
			removeElement(cursor);

		}
		
	}
	
}
