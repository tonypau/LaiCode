/*
A Skip List is a special type of linked list, 
where each of the nodes has a forward pointer to another node in the front and forward pointers are guaranteed to be in non-descending order.

Make a deep copy of the original skip list.
*/


/**
 * class SkipListNode {
 *   public int value;
 *   public SkipListNode next;
 *   public SkipListNode forward;
 *   public SkipListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
 
// we use a map record the relation of original node and copy node
public class Solution {
  public SkipListNode copy(SkipListNode head) {
    if (head == null) return null;
    Map<SkipListNode, SkipListNode> map = new HashMap<>();
    SkipListNode newHead = new SkipListNode(head.value);
    map.put(head, newHead);
    SkipListNode cur = newHead;
    while (head != null) {
      if (head.next != null) {
        if (!map.containsKey(head.next)) {
          map.put(head.next, new SkipListNode(head.next.value));
        }
        cur.next = map.get(head.next);
      }
      if (head.forward != null) {
        if (!map.containsKey(head.forward)) {
          map.put(head.forward, new SkipListNode(head.forward.value));
        }
        cur.forward = map.get(head.forward);
      }
      head = head.next;
      cur = cur.next;
    }
    return newHead;
  }
}

