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
  public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode prev = null;  // 关键点，保存前半段的尾巴
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = null;   // 前后半段割裂开
    ListNode n1 = mergeSort(head);
    ListNode n2 = mergeSort(slow);
    return merge(n1, n2);
  }
  
  private ListNode merge(ListNode node1, ListNode node2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (node1 != null && node2 != null) {
      if (node1.value < node2.value) {
        cur.next = node1;
        node1 = node1.next;
      } else {
        cur.next = node2;
        node2 = node2.next;
      }
      cur = cur.next;
    }
    if (node1 != null) cur.next = node1;
    if (node2 != null) cur.next = node2;
    return dummy.next;
  }
}

