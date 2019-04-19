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
    if (head == null) return node;
    if (head.value >= value) {
      node.next = head;
      return node;
    } 
    ListNode cur = head;
    while (cur.next != null && cur.next.value < value) {
      cur = cur.next;
    }
    node.next = cur.next;
    cur.next = node;
    return head;
  }
}

