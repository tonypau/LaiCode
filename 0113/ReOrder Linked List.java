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
  public ListNode reorder(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode middle = findMiddle(head);
    ListNode node = middle.next;
    middle.next = null;
    ListNode newHead = reverse(node);
    return merge(head, newHead);
  }
  
  private ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  
  private ListNode reverse(ListNode node) {
    if (node == null || node.next == null) return node;
    ListNode cur = node;
    ListNode prev = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
  
  private ListNode merge(ListNode h1, ListNode h2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (h1 != null && h2 != null) {
      cur.next = h1;
      h1 = h1.next;
      cur = cur.next;
      cur.next = h2;
      h2 = h2.next;
      cur = cur.next;
    }
    while (h1 != null) {
      cur.next = h1;
      h1 = h1.next;
      cur = cur.next;
    }
    return dummy.next;
  }
}

