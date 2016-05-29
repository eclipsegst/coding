package challenge;

/**
 * @author Zhaolong Zhong May 28, 2016
 */
public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode result = new ListNode(0);
		result.next = head;
		
		ListNode t = result;
		ListNode pre = head;
		ListNode cur = head;
		
		while (pre != null && pre.next != null) {
			pre = t.next;
			cur = pre.next;
			
			if (cur != null) {
				pre.next = cur.next;
				cur.next = pre;
				t.next = cur;
				t = pre;
			}
		}
		
		return result.next;
	}
	
	public ListNode swapPairsRecursion(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode pre = head;
		ListNode cur = head.next;
		ListNode t = null;
		
		t = cur.next;
		cur.next = pre;
		pre.next = t;
		
		if (t != null) {
			pre.next = swapPairsRecursion(t);
		}
		
		return cur;
	}
	
	public static void main(String[] args) {
		SwapPairs solution = new SwapPairs();
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		
//		ListNode head = solution.swapPairs(l1);
		ListNode head = solution.swapPairsRecursion(l1);
		
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
}
