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
  public ListNode merge(ListNode one, ListNode two) {
    if (one == null || two == null) return one == null ? two : one;
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (one != null && two != null) {
      if (one.value < two.value) {
        cur.next = one;
        one = one.next;
      } else {
        cur.next = two;
        two = two.next;
      }
      cur = cur.next;
    }
    while (one != null) {
      cur.next = one;
      one = one.next;
      cur = cur.next;
    }
    while (two != null) {
      cur.next = two;
      two = two.next;
      cur = cur.next;
    }
    cur.next = null;
    return dummy.next;
  }
}

