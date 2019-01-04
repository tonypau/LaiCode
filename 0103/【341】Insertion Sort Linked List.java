/*
Given a singly-linked list, where each node contains an integer value, sort it in ascending order. The insertion sort algorithm should be used to solve this problem.

Examples

null, is sorted to null
1 -> null, is sorted to 1 -> null
1 -> 2 -> 3 -> null, is sorted to 1 -> 2 -> 3 -> null
4 -> 2 -> 6 -> -3 -> 5 -> null, is sorted to -3 -> 2 -> 4 -> 5 -> 6
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

// use dummy cuz head may change
public class Solution {
  public ListNode insertionSort(ListNode head) {
    if (head == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = head;
    while (cur.next != null) {
      if (cur.next.value < cur.value) {
        ListNode next = cur.next.next;
        insert(dummy, cur.next);  
        cur.next = next;
      } else {
        cur = cur.next;
      }
    }
    return dummy.next;
  }
  
  private void insert(ListNode dummy, ListNode node) {
    ListNode cur = dummy;
    while (cur.next != null && cur.next.value < node.value) {
      cur = cur.next;
    }
    node.next = cur.next;
    cur.next = node;    
  }
}

