/*
Insert a new element at a specific index in the given linked list. The index is 0 based, and if the index is out of the list's scope, you do not need to do anything.

Examples:

1 -> 2 -> 3 -> null, insert 4 at index 3, --> 1 -> 2 -> 3 -> 4 -> null

1 -> 2 -> null, insert 4 at index 0, --> 4 -> 1 -> 2 -> null
*/

public class Solution {
  public ListNode insert(ListNode head, int index, int value) {
    ListNode node = new ListNode(value);
    if (index == 0 || head == null) {
      node.next = head;
      return node;
    }
    ListNode cur = head;
    ListNode prev = null;
    while (index > 0) {
      prev = cur;
      // avoid npe when index is larger than the length of linkedlist
      if (cur == null) return head;
      cur = cur.next;
      index--;
    }
    prev.next = node;
    node.next = cur;
    return head;
  }
}

