/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
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
 
// similar with【320】
public class Solution {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode p = dummy;
    while (p.next != null) {
      if (p.next.value == val) {
        p.next = p.next.next;
      } else {
        p = p.next;
      }
    }
    return dummy.next;
  }
}

