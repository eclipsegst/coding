package u;

/**
 * @author Zhaolong Zhong Sep 28, 2016
 */
public class MergeTwoSortedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode current = result;
		
		while (l1 != null && l2 != null) {
			removeDuplicateAtHead(l1);
			removeDuplicateAtHead(l2);
			
			if (l1.val < l2.val) {				
				current.next = l1;
				l1 = l1.next;
			} else if (l1.val > l2.val) {
				current.next = l2;
				l2 = l2.next;
			} else {
				current.next = l1;
				
				while (l1 != null && current.next.val == l1.val) {
					l1 = l1.next;
				}
				
				while (l2 != null && current.next.val == l2.val) {
					l2 = l2.next;
				}
			}
			
			current = current.next;
		}
		
		while (l1 != null) {
			removeDuplicateAtHead(l1);
			current.next = l1;
			l1 = l1.next;
			current = current.next;
		}
		
		while (l2 != null) {
			removeDuplicateAtHead(l2);
			
			current.next = l2;
			l2 = l2.next;
			current = current.next;
		}
		
		current.next = null;
		
		return result.next;
	}
	
	// Remove duplicate elements at node head, for example, 1, 1, 2, 3, 3 -> 1, 2, 3, 3
	private void removeDuplicateAtHead(ListNode node) {
		ListNode next = node.next;
		while (next != null && node.val == next.val) {
			next = next.next;
		}
		
		node.next = next;
	}
	
	public static void main(String[] args) {
		MergeTwoSortedList solution = new MergeTwoSortedList();
		ListNode l1 = new ListNode(1);
		ListNode l11 = new ListNode(3);
		ListNode l12 = new ListNode(3);
		ListNode l13 = new ListNode(3);
		ListNode l14 = new ListNode(4);
		ListNode l15 = new ListNode(7);
		ListNode l16 = new ListNode(7);
		l1.next = l11;
		l11.next = l12;
		l12.next = l13;
		l13.next = l14;
		l14.next = l15;
		l15.next = l16;
		
		ListNode l2 = new ListNode(1);
		ListNode l21 = new ListNode(2);
		ListNode l22 = new ListNode(3);
		ListNode l23 = new ListNode(4);
		ListNode l24 = new ListNode(4);
		ListNode l25 = new ListNode(6);
		l2.next = l21;
		l21.next = l22;
		l22.next = l23;
		l23.next = l24;
		l24.next = l25;
		
		ListNode result = solution.merge(null, l2);
		
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
