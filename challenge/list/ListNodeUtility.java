package list;

import linkedlist.ListNode;

public class ListNodeUtility {

	/*
	 * Print a singly linked list
	 */
	public static void printListNode(ListNode head) {
		ListNode t = head;
		while (t != null) {
			System.out.print(t.val + " ");
			t = t.next;
		}
		System.out.println();
	}
	
	/*
	 * Copy a singly linked list
	 */
	public static ListNode copyListNode(ListNode head) {
		
		ListNode h = head;
		ListNode c = new ListNode(head.val);
		ListNode cc = c;
		while (h.next != null) {
			cc.next = new ListNode(h.next.val);
			cc = cc.next;
			h = h.next;
		}
		return c;
	}
}
