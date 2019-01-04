/*
Given a list, rotate the list to the right by k places, where k is non-negative.

Input: 1->2->3->4->5->NULL, k = 2

Output: 4->5->1->2->3->NULL

Input: 1->2->3->4->5->NULL, k = 12

Output: 4->5->1->2->3->NULL
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
  public ListNode rotateKplace(ListNode head, int n) {
    if (head == null) return head;
    int length = getLen(head);
    int k = n % length;
    ListNode slow = head;
    ListNode fast = head;
    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }
    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    fast.next = head;
    ListNode newHead = slow.next;
    slow.next = null;
    return newHead;
  }
  
  private int getLen(ListNode head) {
    ListNode node = head;
    int res = 0;
    while (head != null) {
      res++;
      head = head.next;
    }
    return res;
  }
}

