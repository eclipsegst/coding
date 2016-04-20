package challenge;

/* Problem:
 * Given a singly linked list L: L0, L1, ... Ln-1,Ln,
 * reorder it to: L0,Ln,L1,Ln-1,L2,Ln-2...
 * For example, given {1,2,3,4}, reorder it to {1,4,2,3} or {1,2,3,4,5} to {1,5,2,4,3}
 * You must do this in-place without altering the nodes' values
 * Thoughts:
 * This problem is not straightforward, because it requires "in-place" operations. 
 * That means we can only change their pointers, not creating a new list.
 * 
 * Solution:
 * 1. Break list in the middle to two lists (use fast & slow pointers)
 * 2. Reverse the order of the second list
 * 3. Merge two list back together
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
}
public class ReorderList {
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		printList(n1);
//		printList(reverseOrder(n1));
//		reorderList(n1);
		reorderList(n1);
		 
		printList(n1);
		
	}
	
	public static void reorderList(ListNode head){
		if (head != null && head.next != null) {
			 
			ListNode slow = head;
			ListNode fast = head;
 
			//use a fast and slow pointer to break the link to two parts.
			while (fast != null && fast.next != null && fast.next.next!= null) {
				//why need second condition? even node
				//why need third condition? odd node
				//System.out.println("pre "+slow.val + " " + fast.val);
				slow = slow.next;
				fast = fast.next.next;
				//System.out.println("after " + slow.val + " " + fast.val);
			}
			
			ListNode second = slow.next;
			//printList(head);
			slow.next = null; // why? Need to close first part, uncommentout the two lines above and below this line and comment out this line or not
			//printList(head);
			second = reverseOrder(second);
			
			ListNode p1 = head;
			ListNode p2 = second;

			//merge two lists
			while(p2 != null){
				ListNode tmp1 = p1.next;
				ListNode tmp2 = p2.next;
				
				p1.next = p2;
				p2.next = tmp1;
				
				p1 = tmp1;
				p2 = tmp2;
			}
			
		}
	}
	
	public static ListNode reverseOrder(ListNode head){
		if (head == null || head.next == null){
			return head;
		}
		
		ListNode pre = head;
		ListNode cur = head.next;
		
		while (cur!= null){
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		
		head.next = null;
		return pre;
	}
	
	public static void printList(ListNode n){
		System.out.println("------");
		while(n!=null){
			System.out.println(n.val);
			n = n.next;
		}
		System.out.println();
	}

}
