package linkedListLoop;

import linkedlist.ListNode;

/**
 * @author Zhaolong Zhong Nov 23, 2015
 */
public class LinkedListLoop {
	public boolean hasLoop (ListNode head) {
		if (head == null) return false;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) return true;
		}
		
		return false;
	}
	
	public ListNode getEntryOfLoop (ListNode head) {
		if (head == null || head.next == null) return null;
		ListNode slow = head;
		ListNode fast = head;
		ListNode entry = head;
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				while (entry != slow) {
					entry = entry.next;
					slow = slow.next;
				}
				return entry;
			}
		}
		
		return null; 
	}
}
