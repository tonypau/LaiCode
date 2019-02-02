// Use cases:
// 1) return firstNonRepeating char
// 2) remove old one from linkedlist, but maintain it in map.
// 4) when meeting a new first one, record it in linkedlist, add it to the tail.  hashmap

public class Solution {
  Map<Character, ListNode> map;
  ListNode head;
  ListNode tail;
  public Solution() {
    this.map = new HashMap<>();
    this.head = null;
    this.tail = null;
  }
  
  static class ListNode {
    char ch;
    ListNode prev;
    ListNode next;
    public ListNode(char ch) {
      this.ch = ch;
      this.prev = null;
      this.next = null;
    }
  }
  
  public void read(char ch) {
    ListNode node = null;
    if (!map.containsKey(ch)) {
      node = new ListNode(ch);
      if (head == null) {
        head = tail = node;
      } else {
        node.prev = tail;
        tail.next = node;
        tail = node;
      }
      map.put(node.ch, node);
    } else {
      node = map.get(ch);
      remove(node);  
    }
  }
  
  public Character firstNonRepeating() {
    if (head == null || head.count != 1) {
      return null;
    } else {
      return head.ch;
    } 
  }
  
  public ListNode remove(ListNode node) {
    if (node.prev != null) {
      node.prev.next = node.next;
    }
    if (node.next != null) {
      node.next.prev = node.prev;
    }
    if (head == node) {
      head = node.next;
    }
    if (tail == node) {
      tail = node.prev;
    }
    node.prev = node.next = null;
    return node;
  }
}

