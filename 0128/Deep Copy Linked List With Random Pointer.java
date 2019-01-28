/**
 * class RandomListNode {
 *   public int value;
 *   public RandomListNode next;
 *   public RandomListNode random;
 *   public RandomListNode(int value) {
 *     this.value = value;
 *   }
 * }
 */
public class Solution {
  public RandomListNode copy(RandomListNode head) {
    if (head == null) return head;
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    map.put(head, new RandomListNode(head.value));
    RandomListNode cur = head;
    while (cur != null) {
      if (cur.next != null) {
        if (!map.containsKey(cur.next)) {
          map.put(cur.next, new RandomListNode(cur.next.value));
        }
        map.get(cur).next = map.get(cur.next);
      }
      if (cur.random != null) {
        if (!map.containsKey(head.random)) {
          map.put(head.random, new RandomListNode(head.random.value));
        }
        map.get(cur).random = map.get(cur.random);
      }
      cur = cur.next;
    }
    return map.get(head);
  }
}

