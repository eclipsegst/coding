package a;

import linkedlist.ListNode;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 * 
 * Merge k Sorted Lists
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKLists {
	// Runtime: O(N * lgK)
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		
		int end = lists.length - 1;
		
		while (end > 0) {
			int begin = 0;
			while (begin < end) {
				lists[begin] = mergeTwoSortedLists(lists[begin], lists[end]);
				begin++;
				end--;
			}
		}
		
		return lists[0];
	}
	
	// Runtime: O(N)
	private ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
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
}
