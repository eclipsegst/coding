package linkedListInsert;

import linkedlist.ListNode;

/**
 * @author Zhaolong Zhong Nov 24, 2015
 */
public class LinkedListInsert {
	public static ListNode insertListNode(ListNode head, int x) {
		ListNode newNode = new ListNode(x);
		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}
		
		ListNode cur = head;
		
		do {
			if (x <= cur.next.val && x >= cur.val) break;
			// between max and min
			if (cur.val > cur.next.val && (x < cur.next.val || x > cur.val)) break;
			cur = cur.next;
		} while (cur != head);
		
		newNode.next = cur.next;
		cur.next = newNode;
		
		return newNode;
	}
	
	public static void main(String[] args) {
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node0;
		
		printList(node2);
		
		ListNode newNode = insertListNode(node2, 6);
		printList(newNode);
	}
	
	private static void printList(ListNode head) {
		ListNode cur = head;
		do {
			System.out.print(cur.val + " ");
			cur = cur.next;
		} while (cur != head);
		System.out.println();
	}
}
