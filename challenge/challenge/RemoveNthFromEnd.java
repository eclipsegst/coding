/**
 * Author : Zhaolong Zhong
 * Date   : Feb 4, 2015 2:43:10 PM
 * Problem:
 * Remove Nth Node From End of List
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example, given linked list: 1->2->3->4->5, and n = 2. After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note: Given n will always be valid. Try to do this in one pass.
 */
package challenge;
import java.util.Map;
import java.util.HashMap;
public class RemoveNthFromEnd {
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val  = x;
      next = null;
    }
  }
  public ListNode removeNthFromEndHash(ListNode head, int n) {
    if(head.next == null) return null;
    Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
    ListNode cur = head;
    int size = 0;
    while(cur != null){
      map.put(size, cur);
      cur = cur.next;
      size += 1;
    }
    cur = map.get(size - n);
    ListNode pre = map.get(size - n - 1);
    if(pre != null) pre.next = cur.next;
    else head = cur.next;
    cur.next = null;
    return head;
  }
  
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null) return null;
    final ListNode res = new ListNode(0);
    res.next = head;
    ListNode fast = res;
    ListNode slow = res;
    for(int i = 0; i < n; i++) fast = fast.next;
    while(fast != null && fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return res.next;
  }
}