package a;

import linkedlist.ListNode;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 */
public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int lengthMin = Math.min(length(headA), length(headB));
        
        // trim the head nodes of the longer list to make the lists length equal
        ListNode nodeA = trim(headA, length(headA) - lengthMin);
        ListNode nodeB = trim(headB, length(headB) - lengthMin);
        
        while (nodeA != null && nodeB != null) {
        	if (nodeA.equals(nodeB)) {
        		return nodeA;
        	}
        	
        	nodeA = nodeA.next;
        	nodeB = nodeB.next;
        }
        
        return null;
    }
	
	private int length(ListNode head) {
		ListNode temp = head;
		
		int length = 0;
		
		while (temp != null) {
			temp = temp.next;
			length++;
		}
		
		return length;
	}
	
	// Trim n nodes from head
	private ListNode trim(ListNode head, int n) {
		ListNode temp = head;
		while (n > 0) {
			temp = temp.next;
			n--;
		}
		
		return temp;
	}
	
	public static void main(String[] args) {
		IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();
	
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		
		l1.next = l2;
		l2.next = l6;
		
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		
		ListNode result = solution.getIntersectionNode(l1, l3);
		System.out.println(result.val);
	}
}
