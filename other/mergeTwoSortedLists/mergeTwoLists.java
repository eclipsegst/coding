package mergeTwoSortedLists;

import listNode.ListNode;

/**
 * @author Zhaolong Zhong Nov 22, 2015
 */
public class mergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		ListNode res = new ListNode(0);
		ListNode cur = res;
		
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
		
		if (l1 != null) cur.next = l1;
		else cur.next = l2;
		
		return res.next;
	}
}
