package ru.kpfu.ivmiit.apa;

public class Node<T> {
	private T value;
	private Node<T> next;
	private Node<T> prev;
	public T getValue() {
		return value;
	}
	
	public  void setValue(T value) {
		this.value = value;
	}
	public Node<T> getNext() {
		return next;
	}
	protected void setNext(Node<T> value){
		next=value;
	}
	public Node(T value){
		this.value=value;
	}
	public Node<T> getPrev() {
		return prev;
	}
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
}
