package addtwonumbers;
/*
 * Date: 01/24/2015 20:00
 * Problem:
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers an return it as a linked list.
 * For example,
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 ->8
 */
// Definition for singly-linked list
class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
    next = null;
  }
}

public class AddTwoNumbers {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode r = new ListNode(0);
    ListNode h = r;
    ListNode beforeend = r;
    while (l1 != null && l2 != null) {
      r.val += l1.val + l2.val;
      r.next = new ListNode(r.val/10);
      r.val %= 10;
      beforeend = r;
      r = r.next;   // r points to tailing node
      l1 = l1.next; // remove the leading node
      l2 = l2.next;
    }
    
    ListNode rest;
    if (l1 == null) rest = l2;
    else rest = l1;
    
    while (rest != null) {
      r.val += rest.val;
      r.next = new ListNode(r.val/10);
      r.val %= 10;
      beforeend = r;
      r = r.next;
      rest = rest.next;
    }
    if (beforeend.next != null && beforeend.next.val == 0) {
      beforeend.next = null; // remove the tailing node with val = 0
    }
    return h;
  }
  
  // review version
  public static ListNode addTwoNumbersReview(ListNode l1, ListNode l2) {
    ListNode res = new ListNode(0);
    ListNode cur = res;
    int f = 0;
    while (l1 != null && l2 != null) {
      cur.next = new ListNode((l1.val + l2.val + f)%10);
      f = (l1.val + l2.val + f) / 10; 
      cur = cur.next;
      l1 = l1.next;
      l2 = l2.next;
    }
    
    ListNode rest;
    if (l1 != null) {
      rest = l1;
    } else {
      rest = l2;
    }
    
    while (rest != null) {
      cur.next = new ListNode((rest.val + f) % 10);
      cur = cur.next;
      f = (rest.val + f) / 10;
      rest = rest.next;
    }
    
    if (f == 1) {
      cur.next = new ListNode(1);
    }
    return res.next; 
  }
  
  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    ListNode l2 = new ListNode(4);
    ListNode l3 = new ListNode(3);
    l1.next = l2;
    l2.next = l3;
    
    ListNode l4 = new ListNode(5);
    ListNode l5 = new ListNode(6);
    ListNode l6 = new ListNode(4);
    ListNode l7 = new ListNode(5);
    l4.next = l5;
    l5.next = l6;
    l6.next = l7;
    
//    ListNode res = addTwoNumbers(l1,l4);
    ListNode res = addTwoNumbersReview(l1,l4);
    System.out.println(res.val);
    while(res.next != null) {
      res = res.next;
      System.out.println(res.val);
    }
  }
}
