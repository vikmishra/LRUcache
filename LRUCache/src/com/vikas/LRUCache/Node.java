package com.vikas.LRUCache;

/*Doubly Linked List Containing Key-Value Pair*/
public class Node {

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	int key;
	int value;
	Node previous;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
