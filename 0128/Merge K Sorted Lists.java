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
    PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode e1, ListNode e2) {
        if (e1.value == e2.value) {
          return 0;
        }
        return e1.value < e2.value ? -1 : 1;
      }
    });
    for (ListNode node : listOfLists) {
      pq.offer(node);
    }
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    while (!pq.isEmpty()) {
      ListNode cur = pq.poll();
      curr.next = cur;
      curr = cur;
      if (cur.next != null) {
        pq.offer(cur.next);
      }
    }
    return dummy.next;
  }
}

