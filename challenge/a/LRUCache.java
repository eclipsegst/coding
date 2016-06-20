package a;

import java.util.HashMap;

/**
 * @author Zhaolong Zhong Jun 19, 2016
 * 
 * LRU Cache
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
class Node {
	int key;
	int value;
	Node pre;
	Node next;
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
public class LRUCache {
	private final int CAPACITY;
	private HashMap<Integer, Node> map;
	private Node head = null;
	private Node end = null;
	
	public LRUCache(int capacity) {
		this.CAPACITY = capacity;
		this.map = new HashMap<Integer, Node>();
	}
	
	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}
	
	public void remove(Node n) {
		if (n.pre != null) {
			n.pre.next = n.next;
		} else {
			head = n.next;
		}
		
		if (n.next != null) {
			n.next.pre = n.pre;
		} else {
			end = n.pre;
		}
	}
	
	public void setHead(Node n) {
		n.next = head;
		n.pre = null;
		
		if (head != null) {
			head.pre = n;
		}
		
		head = n;
		
		if (end == null) {
			end = head;
		}
	}
	
	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node newNode = new Node(key, value);
			if (map.size() >= CAPACITY) {
				map.remove(end.key);
				remove(end);
				setHead(newNode);
			} else {
				setHead(newNode);
			}
			
			map.put(key, newNode);
		}
	}
}
