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
  // recursive
  public ListNode reverse(ListNode head) {
  // NOTICE do not forget to check head.next == null
    if (head == null || head.next == null) return head;
    ListNode newHead = reverse(head.next);
  // here we call head.next.next, so we need to check before
    head.next.next = head;
    head.next = null;
    return newHead;
  }
  
  // iterative
  public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode cur = head;
    ListNode prev = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;   // only change the next of cur
      prev = cur;
      cur = next;
    }
    return prev;
  }
}

