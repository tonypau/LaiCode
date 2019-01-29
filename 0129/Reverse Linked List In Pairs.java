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
  public ListNode reverseInPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode next = head.next; 
    head.next = reverseInPairs(head.next.next);
    next.next = head;
    return next;
  }
}

