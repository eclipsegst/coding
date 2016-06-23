package a;

import linkedlist.ListNode;

/**
 * @author Zhaolong Zhong Jun 21, 2016
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
        	return l2;
        }
        
        if (l2 == null) {
        	return l1;
        }
        
		ListNode head = new ListNode(0);
		ListNode cur = head;
        
		int flag = 0;
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + flag;
			cur.next = new ListNode(sum % 10);
			flag = sum/10;
			
			l1 = l1.next;
			l2 = l2.next;
			cur = cur.next;
		}
		
		cur.next = l1 != null ? l1 : l2;
		
		while (cur.next != null) {
			cur = cur.next;
			int sum = cur.val + flag;
			cur.val = sum % 10;
			flag = sum / 10;
		}
		
		if (flag == 1) {
			cur.next = new ListNode(1);
		}
		
		return head.next;
    }
	
	public static void main(String[] args) {
		AddTwoNumbers solution = new AddTwoNumbers();
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(6);
		l4.next = l5;
		l5.next = l6;
		
		ListNode head = solution.addTwoNumbers(l1, l4);
		
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
