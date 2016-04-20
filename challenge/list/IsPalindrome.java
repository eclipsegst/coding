package list;

import linkedlist.ListNode;
import list.ListNodeUtility;

public class IsPalindrome {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(1);
		ListNode n6 = new ListNode(0);
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		System.out.println("Input:");
		ListNodeUtility.printListNode(head);
		System.out.println(isPalindrome(head));
		// mid function will break the original list
		
		ListNodeUtility.printListNode(head);
		System.out.println(isPalindromeOne(head));

	}

	/*
	 * Solution 1:
	 * 1. Copy the input ListNode
	 * 2. Reverse the new ListNode
	 * 3. Compare each node
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n)
	 */
	private static boolean isPalindromeOne(ListNode head) {
		
		if (head == null) return true;
        
		ListNode rev = new ListNode(head.val);
        ListNode c = rev;
        ListNode h = head;
        while (h.next != null) {
            c.next = new ListNode(h.next.val);
            c = c.next;
            h = h.next;
        }

        rev = reverse(rev);
        
        while (head != null && rev != head) {
            if (head.val != rev.val) return false;
            head = head.next;
            rev =rev.next;
        }
        
        return true;
	}
	
	/*
	 * Solution 2:
	 * 1. find the middle node
	 * 2. reverse the second half list
	 * 3. compare each node between node in first half list and node in the second half list.
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	private static boolean isPalindrome(ListNode head) {
		ListNode m = mid(head);
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
	
	/*
	 * Find the middle node
	 */
	private static ListNode mid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	
	/*
	 * Reverse a linked list
	 */
	private static ListNode reverse(ListNode head) {
        ListNode prev = null;
       
        while(head != null){
            
            ListNode t = head.next;
            head.next = prev;
            prev = head;
            head = t;
            
        }
        
        return prev;
    }
	
}
