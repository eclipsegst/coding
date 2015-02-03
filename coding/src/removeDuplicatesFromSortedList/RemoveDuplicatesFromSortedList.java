/**
 * Author : Zhaolong Zhong
 * Date   : Feb 2, 2015 11:54:19 PM
 * 
 * Problem:
 * Remove duplicates from Sorted List
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
package removeDuplicatesFromSortedList;

public class RemoveDuplicatesFromSortedList {
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
    ListNode node = head.next;
    ListNode lastHead = head;
    while(node != null) {
      while(node != null && node.val == lastHead.val) node = node.next;
      lastHead.next = node;
      lastHead = node;
      if(node != null) node = node.next;
    }
    return head;
  }
}
