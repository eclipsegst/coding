/**
 * Author : Zhaolong Zhong
 * Date   : Feb 4, 2015 9:02:50 AM
 * 
 * Problem:
 * Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 */
package mergeTwoSortedLists;

public class MergeTwoSortedLists {
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
  public ListNode mergeTwoList(ListNode l1, ListNode l2) {
    ListNode res = new ListNode(0);
    ListNode cur = res;
    while(l1 != null && l2 != null) {
      if(l1.val <= l2.val) {
        cur.next = l1.next;
        l1 = l1.next;
      } else {
        cur.next = l2.next;
        l2 = l2.next;
      }
      cur = cur.next;
    }
    
    if(l1 != null) cur.next = l1;
    else cur.next = l2;
    return res.next;
  }
}
