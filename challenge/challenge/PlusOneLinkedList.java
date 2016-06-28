package challenge;

/**
 * @author Zhaolong Zhong Jun 28, 2016
 * 
 * Plus One Linked List
 * 
 * Given a non-negative number represented as a singly linked list of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * Example:
 * Input:
 * 1->2->3
 * 
 * Output:
 * 1->2->4
 */
public class PlusOneLinkedList {
	public ListNode plusOne(ListNode head) {
        if (head == null) {
        	return null;
        }
        
        int[] flag = new int[]{0};
        
        ListNode node = plusOneHelper(head, flag);

        if (flag[0] == 1) {
        	ListNode newHead = new ListNode(1);
        	newHead.next = node;
        	node = newHead;
        }
        
        return node;
    }
	
	public ListNode plusOneHelper(ListNode head, int[] flag) {
		if (head == null) {
			return null;
		}
		
		ListNode next = plusOneHelper(head.next, flag);
		
		if (next == null) {
			// current node is the end node
			int sum = head.val + 1;
			flag[0] = sum / 10;
			head.val = sum % 10;;
		}
		
		if (next != null && flag[0] == 1) {
			int sum = head.val + 1;
			flag[0] = sum / 10;
			head.val = sum % 10;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		PlusOneLinkedList solution = new PlusOneLinkedList();
		
		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(9);
		ListNode l3 = new ListNode(9);
		l1.next = l2;
		l2.next = l3;
		
		ListNode result = solution.plusOne(l1);
		
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
