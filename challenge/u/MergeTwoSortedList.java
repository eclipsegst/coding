package u;

import helpers.ListNode;

/**
 * @author Zhaolong Zhong Sep 28, 2016
 */
public class MergeTwoSortedList {
	// Merge two sorted list
	public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            
            current = current.next;
        }
        
        current.next = l1 != null ? l1 : l2;
        return head.next;
    }
	
	// Merge two sorted list without duplicate values
	public ListNode mergeListWithoutDuplicates(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (current.val == l1.val) {
                    l1 = l1.next;
                    continue;
                }
                current.next = l1;
                l1 = l1.next;
            } else {
                if (current.val == l2.val) {
                    l2 = l2.next;
                    continue;
                }
                current.next = l2;
                l2 = l2.next;
            }
            
            current = current.next;
        }
       
        while (l1 != null) {
			if (current.val == l1.val) {
			    l1 = l1.next;
			    if (current.next != null) {
			    	current.next = null;
			    }
			    continue;
			}
			
			current.next = l1;
			l1 = l1.next;
			current = current.next;
		}
		
		while (l2 != null) {
			if (current.val == l2.val) {
			    l2 = l2.next;
			    if (current.next != null) {
			    	current.next = null;
			    }
			    continue;
			}
			
			current.next = l2;
			l2 = l2.next;
			current = current.next;
		}
        
        return head.next;
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
		
		ListNode result = solution.mergeList(l1, l2);
//		ListNode result = solution.mergeListWithoutDuplicates(l1, l2);
		
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}
}
