/*
Delete the node at the given index for the given linked list.

Examples

[1, 2, 3], delete at 1 --> [1, 3]

[1, 2, 3], delete at 4 --> [1, 2, 3]

[1, 2, 3], delete at 0 --> [2, 3]

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
  public ListNode deleteNode(ListNode head, int index) {
    if (head == null) return head;
    if (index == 0) {
      return head.next;
    }
    ListNode prev = null;
    ListNode cur = head;
    while (index > 0) {
      prev = cur;
      // avoid npe
      if (cur == null) return head;
      cur = cur.next;
      index--;
    }
    // avoid npe
    if (cur == null) return head;
    prev.next = cur.next;
    return head;
  }
}

