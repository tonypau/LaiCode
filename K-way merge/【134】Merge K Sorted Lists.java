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
  public ListNode merge(List<ListNode> listOfLists) {
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode n1, ListNode n2) {
        if (n1.value == n2.value) return 0;
        return n1.value < n2.value ? -1 : 1;
      }
    });
    for (ListNode node : listOfLists) {
      minHeap.offer(node);
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (!minHeap.isEmpty()) {
      ListNode node = minHeap.poll();
      cur.next = node;
      if (node.next != null) minHeap.offer(node.next);
      cur = cur.next;
    }
    cur.next = null;
    return dummy.next;
  }
}

