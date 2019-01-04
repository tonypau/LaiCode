/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Input: 1->1->2

Output: 1->2
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
 
// no need of dummy head because head must be in the answer
public class Solution {
  public ListNode removeDup(ListNode head) {
    if (head == null) return head;
    ListNode prev = head;
    ListNode cur = head.next;
    while (cur != null) {
      if (prev.value == cur.value) {
        // NOTICE: prev cannot move under this case. 
        //          because maybe cur.next still has the same value as cur
        prev.next = cur.next;
        cur = cur.next;
      } else {
        prev = prev.next; 
      }
    }
    return head;
  }
}

