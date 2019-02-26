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
 
// Data structure: 1) map: key-value: node-clone node
//                 2) cur node
// Initialize: 1) put the head node and its clone into map
//             2) cur = newHead
// For each step: 
//    head = head.next
//    check if head.next and head.random is in the map respectively to decide whether or not we need to clone its next node and random node

// TC: O(n) traverse once
// SC: O(n) map size
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
          cur.next = new RandomListNode(head.next.value);
          map.put(head.next, cur.next);
        } else {
          cur.next = map.get(head.next);
        }
      }
      if (head.random != null) {
        if (!map.containsKey(head.random)) {
          cur.random = new RandomListNode(head.random.value);
          map.put(head.random, cur.random);
        } else {
          cur.random = map.get(head.random);
        }
      }
      head = head.next;
      cur = cur.next;
    }
    return newHead;
  }
}

