package a;

import linkedlist.ListNode;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 * 
 * Palindrome Linked List
 * 
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return false;
		}
		
		ListNode m = findMiddle(head);
		m = reverse(m);
		
		while (m != head && m != null) {
			if (m.val != head.val) {
				return false;
			}
			
			m = m.next;
			head = head.next;
		}
		
		return true;
	}
	
	// find middle node
	private ListNode findMiddle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	// reverse list
	private ListNode reverse(ListNode head) {
		
		ListNode pre = null;
		
		while (head != null) {
			ListNode t = head.next;
			head.next = pre;
			pre = head;
			head = t;
		}
		
		return pre;
	}
}
