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
  public ListNode insert(ListNode head, int value) {
    ListNode node = new ListNode(value);
    if (head == null || head.value >= value) {
      node.next = head;
      return node;
    }
    ListNode cur = head;
    // find the last element that should be in the left side of the new node
    while (cur != null && cur.next != null) {
      if (cur.value <= value && cur.next.value <= value) {
        cur = cur.next;
      } else {
        break;
      }
    }
    node.next = cur.next;
    cur.next = node;
    return head;
  }
}

