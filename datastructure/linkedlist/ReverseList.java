package linkedlist;

public class ReverseList {
	
	public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode pre = head.next;
        ListNode cur = head.next;
        
        head.next = null;
        while(cur != null) {
            pre = cur;
            cur = cur.next;
            pre.next = head;
            head = pre;
        }
        
        return head;
    }

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		
		ListNode ref = reverseList(head);
		
		while(ref != null) {
			System.out.print(ref.val + " ");
			ref = ref.next;
		}
	}

}
