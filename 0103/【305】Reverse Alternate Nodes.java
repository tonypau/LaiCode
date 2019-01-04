/*
Given a linked list, reverse alternate nodes and append at the end.

Examples:

Input List:    1 -> 2 -> 3 -> 4 -> 5 -> 6

Output List: 1 -> 3 -> 5 -> 6 -> 4 -> 2

Input List:    1 -> 2 -> 3 -> 4 -> 5

Output List: 1 -> 3 -> 5 -> 4 -> 2
*/

/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode reverseAlternate(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) return head;
    ListNode dummy = new ListNode(0);
    ListNode p = dummy;
    ListNode cur = head;
    while (cur.next != null) {
      p.next = cur.next;
      p = p.next;
      cur.next = cur.next.next;
      // when cur.next == null, cur should not move to cur.next
      // because we should call cur.next in below steps (line 42),
      // which is appending reversed second sequence to cur.
      if (cur.next != null) cur = cur.next;  
    }
    p.next = null;
    ListNode node = reverse(dummy.next);
    cur.next = node;
    return head;
  }
  
  private ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode cur = head;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}

