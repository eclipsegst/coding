/**
 * Author : Zhaolong Zhong
 * Date   : 2015 11:36:15 PM
 * Problem:
 * Reverse a singly linked list.
 * Hint: 
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
package reverselist;

public class ReverseList {
  
  public ListNode reverseList(ListNode head) {
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
  
  public ListNode reverseList2(ListNode head) {
    if (head == null || head.next == null) return head;
    
    ListNode tail = head.next;
    ListNode reversedRest = reverseList2(head.next);
    
    tail.next = head;
    head.next = null;
    
    return reversedRest;
  }
  
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
}



