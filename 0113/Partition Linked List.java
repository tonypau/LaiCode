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
  public ListNode partition(ListNode head, int target) {
    if (head == null || head.next == null) return head;
    ListNode smaller = new ListNode(0);
    ListNode larger = new ListNode(0);
    ListNode cur1 = smaller;
    ListNode cur2 = larger;
    ListNode curr = head;
    while (curr != null) {
      if (curr.value < target) {
        cur1.next = curr;
        cur1 = cur1.next;
      } else {
        cur2.next = curr;
        cur2 = cur2.next;
      }
      curr = curr.next;
    }
    cur2.next = null;
    cur1.next = larger.next;
    return smaller.next;
  }
}

