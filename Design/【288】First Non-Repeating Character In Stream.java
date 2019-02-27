/*
case1: if a letter doesn't exist in hashmap at all, this letter hasn't appeared. we need to add into map and append to tail
case2: if a letter exists in hashmap and its value is not null, this letter has appeared exactly once, we need to update it in map with null node
case3: if a letter exists in hashmap and its value is null, this letter has appeared more than once, we just ignore.

return the character of head. 
*/
public class Solution {
  Map<Character, ListNode> map;
  ListNode head;
  ListNode tail;
  
  public Solution() {
    this.map = new HashMap<Character, ListNode>();
  }
  
  static class ListNode {
    char c;
    ListNode prev;
    ListNode next;
    
    ListNode(char c) {
      this.c = c;
    }
  }
  
  public void read(char ch) {
    ListNode node = null;
    if (map.containsKey(ch)) {
      if (map.get(ch) == null) return;
      node = map.get(ch);
      remove(node);
    } else {
      node = new ListNode(ch);
      append(node);
    }
  }
  
  private ListNode remove(ListNode node) {
    map.put(node.c, null);
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
  
  private ListNode append(ListNode node) {
    map.put(node.c, node);
    if (tail == null) {
      head = tail = node;
    } else {
      tail.next = node;
      node.prev = tail;
      tail = node;
    }
    return node;
  }
  
  public Character firstNonRepeating() {
    return head == null ? null : head.c;
  }
}

