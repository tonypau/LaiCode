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
    // 找中点，切一半。
    // 注意，重点是一定要保证切一半。
    // 当还剩两个的时候，如果不用prev，用slow的next作为n2的话，没办法将两个元素平分成两份，这样就会死循环。
    ListNode prev = null;  
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = null;
    ListNode n1 = mergeSort(head);
    ListNode n2 = mergeSort(slow);
    return merge(n1, n2);
  }
  
  private ListNode merge(ListNode n1, ListNode n2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (n1 != null && n2 != null) {
      if (n1.value < n2.value) {
        cur.next = n1;
        n1 = n1.next;
      } else {
        cur.next = n2;
        n2 = n2.next;
      }
      cur = cur.next;
    }
    if (n1 != null) cur.next = n1;
    if (n2 != null) cur.next = n2;
    return dummy.next;
  }
}


