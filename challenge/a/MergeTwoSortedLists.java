package a;

import linkedlist.ListNode;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		
		if (l2 == null) {
			return l1;
		}
		
		ListNode head = new ListNode(0);
		ListNode cur = head;
		
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			
			cur = cur.next;
		}
		
		cur.next = l1 != null ? l1 : l2;
		
		return head.next;
	}
	
	public static void main(String[] args) {
		MergeTwoSortedLists solution = new MergeTwoSortedLists();
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		
		l1.next = l3;
		l3.next = l5;
		
		l2.next = l4;
		l4.next = l6;
		
		ListNode result = solution.mergeTwoLists(l1, l2);
		
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
