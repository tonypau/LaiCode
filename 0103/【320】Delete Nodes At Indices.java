/*
Given a linked list and an sorted array of integers as the indices in the list. Delete all the nodes at the indices in the original list.

Examples

1 -> 2 -> 3 -> 4 -> NULL, indices = {0, 3, 5}, after deletion the list is 2 -> 3 -> NULL.

Assumptions

the given indices array is not null and it is guaranteed to contain non-negative integers sorted in ascending order.
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
  public ListNode deleteNodes(ListNode head, int[] indices) {
    if (head == null || indices == null || indices.length == 0) return head;
    // the head may be lost in this problem, so we maintain a dummy head.
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode p = dummy;
    int count = 0;
    int i = 0;
    while(p.next != null) {
      if (i >= indices.length) return dummy.next;   // avoid arrayoutofbound exception
      if(count == indices[i]){
        i++;
        ListNode next = p.next;
        p.next = next.next; 
      } else {
        // only when count != indices[i], we move p
        p = p.next;
      }
      count++;
    }
    return dummy.next;
  }
}
