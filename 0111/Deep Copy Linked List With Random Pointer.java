/*
[131] same as deep copy skip list
Each of the nodes in the linked list has another pointer pointing to a random node in the list or null.
Make a deep copy of the original list.
*/

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
    if (head == null) return null;
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode newHead = new RandomListNode(head.value);
    map.put(head, newHead);
    RandomListNode cur = newHead;
    while (head != null) {
      if (head.next != null) {
        if (!map.containsKey(head.next)) {
          map.put(head.next, new RandomListNode(head.next.value));
        }
        cur.next = map.get(head.next);
      }
      if (head.random != null) {
        if (!map.containsKey(head.random)) {
          map.put(head.random, new RandomListNode(head.random.value));
        }
        cur.random = map.get(head.random);
      }
      head = head.next;
      cur = cur.next;
    }
    return newHead;
  }
}

