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
  public ListNode selectionSort(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode min = head;
    ListNode beforeMin = null;
    ListNode cur;
    // 这个for的写法很简洁
    for (cur = min; cur.next != null; cur = cur.next) {
      if (cur.next.value < min.value) {
        min = cur.next;
        beforeMin = cur;
      }
    }
    if (head != min) {
      head = swapNodes(head, beforeMin, min);
    }
    // 用recursion，每次遍历都找出剩余里的最小node，调到head去，注意点在于要保存beforeMin
    head.next = selectionSort(head.next);
    return head;
  }
  
  private ListNode swapNodes(ListNode head, ListNode beforeMin, ListNode cur) {
    beforeMin.next = cur.next;
    cur.next = head;
    return cur;
  }
}

