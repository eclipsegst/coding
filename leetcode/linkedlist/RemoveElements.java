/**
 * Author : Zhaolong Zhong
 * Date   : 2015 12:10:46 AM
 * Problem:
 * Remove all elements from a linked list of integers that have value val.
 */
package linkedlist;

public class RemoveElements {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) return null;
    
    while (head.val == val) {
        head = head.next;
        if (head == null) return null;
    }
    
    ListNode pre = head;
    ListNode cur = head.next;
    
    while (cur != null) {
        if (cur.val == val) {
            cur = cur.next;
            pre.next = null;
        } else {
            
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }
    }
    
    return head;
  }
}
