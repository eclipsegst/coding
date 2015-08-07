package linkedlist;

public class InsertNodeAtTail {

	public static ListNode InsertTail(ListNode head, int x) {
		if (head == null) return null;
		
		ListNode ref = head;
		
		while (ref.next != null) {
			ref = ref.next;
		}
		
		ListNode tmp = new ListNode(x);
		ref.next = tmp;
		
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
		
		ListNode ref = head;
		while(ref != null) {
			System.out.print(ref.val + " ");
			ref = ref.next;
		}

		InsertTail(head, 5);
		
		ref = head;
		while(ref != null) {
			System.out.print(ref.val + " ");
			ref = ref.next;
		}

	}

}
