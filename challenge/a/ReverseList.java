package a;

import linkedlist.ListNode;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 * 
 * Reverse Linked List
 * 
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseList {
	//iterative
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		
		while (head != null) {
			ListNode t = head.next;
			head.next = pre;
			pre = head;
			head = t;
		}
		
		return pre;
	}
	
	// recursive
	public ListNode reverseListRecurisve(ListNode head) {
		if (head == null || head.next  == null) {
			return head;
		}
		
		ListNode tail = head.next;
		ListNode reversedRest = reverseListRecurisve(head.next);
		tail.next = head;
		head.next = null;
		
		return reversedRest;
	}
	
	public static void main(String[] args) {
		ReverseList solution = new ReverseList();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
//		ListNode head = solution.reverseList(l1);
		ListNode head = solution.reverseListRecurisve(l1);
		
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
