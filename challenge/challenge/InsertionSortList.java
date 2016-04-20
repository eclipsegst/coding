/**
 * Author : Zhaolong Zhong
 * Date   : Feb 17, 2015 8:57:37 PM
 * Problem:
 * Insertion Sort List
 * Sort a linked list using insertion sort.
 * 
 */
package challenge;

public class InsertionSortList {
  public static  ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode res = new ListNode(Integer.MIN_VALUE);
    res.next = head;
    head = head.next;
    res.next.next = null;
    
    next:
    while (head != null) {
      ListNode taken = head;
      head = head.next;
      
      ListNode cur = res.next;
      ListNode pre = res;
      
      while (cur != null) {
        if (cur.val > taken.val){
          pre.next   = taken;
          taken.next = cur;
          continue next;
        }
        cur = cur.next;
        pre = pre.next;
      }
      pre.next = taken;
      taken.next = null;
    }
    
    return res.next;
  }
  
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(1);
    insertionSortList(head);
  }
}
