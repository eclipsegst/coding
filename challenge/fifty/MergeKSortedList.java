package fifty;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import linkedlist.ListNode;
/**
 * @author Zhaolong Zhong Nov 27, 2015
 */
public class MergeKSortedList {
	private static final Comparator<ListNode> listComparator = new Comparator<ListNode>() {
		@Override
		public int compare(ListNode x, ListNode y) {
			return x.val - y.val;
		}
	};
	
	// Brute Force - O(nk log k) runtime, O(k) space
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.isEmpty()) return null;
		Queue<ListNode> queue = new PriorityQueue<>(lists.size(), listComparator);
		
		for (ListNode node : lists) {
			if (node != null) queue.add(node);
		}
		ListNode head = new ListNode(0);
		ListNode c = head;
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			c.next = node;
			c = c.next;
			if (node.next != null) queue.add(node.next);
		}
		
		return head.next;
	}
	
	// Divide and Conquer - O(nk log k) runtime, O(1) space
	public ListNode mergeKListsTwo(List<ListNode> lists) {
		if (lists.isEmpty()) return null;
		int end = lists.size() - 1;
		MergeTwoSortedLists mergeTwo = new MergeTwoSortedLists();
		while (end > 0) {
			int begin = 0;
			while (begin < end) {
				lists.set(begin,  mergeTwo.mergeTwoLists(lists.get(begin), lists.get(end)));
				begin++;
				end--;
			}
		}
		
		return lists.get(0);
	}
}
