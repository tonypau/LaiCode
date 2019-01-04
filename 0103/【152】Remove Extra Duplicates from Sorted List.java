/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Input:  1->2->3->3->4->4->5

Output: 1->2->5    

Input:  1->1->1

Output: NULL
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
  public ListNode removeDup(ListNode head) {
    if (head == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = dummy.next;
    while (fast != null) {
      if (fast.next != null && fast.value == fast.next.value) {
        while (fast != null && fast.next != null && fast.next.value == fast.value) {
          fast = fast.next;
        }
        slow.next = fast.next;
        fast = fast.next;
      } else {
        slow = slow.next;
        fast = fast.next;
      }
    }
    return dummy.next;
  }
}

