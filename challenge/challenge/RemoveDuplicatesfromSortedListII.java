/**
 * Author : Zhaolong Zhong
 * Date   : Feb 3, 2015 12:24:11 AM
 * 
 * Problem:
 * Remove Duplicates from Sorted List II
 * Given a sorted linked list, delete all nodes that have duplicated numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
package challenge;

public class RemoveDuplicatesfromSortedListII {
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }
  public ListNode deleteDuplicates(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode node = head;
    boolean stop = false;
    int val = head.val;
    while(node.next != null && node.next.val == val) {
      node = node.next;
      stop = true;
    }
    
    if(stop) head = deleteDuplicates(node.next);
    else head.next = deleteDuplicates(head.next);
    return head;
  }
}
