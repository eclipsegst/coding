/**
 * Author : Zhaolong Zhong
 * Date   : Jan 29, 2015 6:24:43 PM
 *
 * Problem:
 * Write a program to find the node at which the intersection of two singly linked lists begin.
 * For example, the following two linked lists:
 * A:       a1 -> a2 \
 *                    c1 -> c2 -> c3
 * B: b1 -> b2 -> b3 /
 * begin to intersection at node c1.
 * 
 * Notes:
 * - If the two linked lists have no intersection at all, return null.
 * - The linked lists must retain their original structure after the function returns.
 * - You may assume there are no cycles anywhere in the entire linked structure.
 * - Your code should preferably run in O(n) time and use only O(1) memory.
 */
package challenge;

public class IntersectionOfTwoLinkedLists {
  int len(ListNode head) {
    ListNode temp = head;
    if(temp == null) return 0;
    int n = 1;
    while(temp.next != null){
      n++;
      temp = temp.next;
    }
    return n;
  }
  
  ListNode trim(ListNode head, int n) {
    ListNode temp = head;
    int c = len(temp) - n;
    while(c >0 && temp.next != null){
      c--;
      temp = temp.next;
    }
    return temp;
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode intersection = null;
    int lenMin = Math.min(len(headA), len(headB));
    ListNode A = trim(headA, lenMin);
    ListNode B = trim(headB, lenMin);
    while(A != null && B != null) { 
      if(A.val != B.val) {
        intersection = null;
      } else if(intersection == null) {
        intersection = A;
        break;
      }
      A = A.next;
      B = B.next;
    } 
    return intersection;
  }
}
