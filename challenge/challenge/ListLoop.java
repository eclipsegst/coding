package challenge;

/**
 * @author Zhaolong Zhong May 3, 2016
 */
public class ListLoop {
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		
		ListNode fast = head;
		ListNode slow = head;
		
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow) {
				return true;
			}
		}
		
		return false;
	}
	
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		
		ListNode entry = head;
		ListNode fast = head;
		ListNode slow = head;
		
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if (fast == slow) {
				while (entry != slow) {
					entry = entry.next;
					slow = slow.next;
				}
				
				return entry;
			}
		}
		
		return null;
	}
}
