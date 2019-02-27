/*
  case 1: when a new request coming in
      case 1.1: when the size is not full, we just add to the newest 
      case 1.2: when the size is full, we need to delete the oldest and add to the newest 

  case 2: when a old request coming in, we need to update its position to the newest
          alse we need to return the value of it when calling get() and update its position
*/

public class Solution<K, V> {
  private Map<K, ListNode<K, V>> map;
  private final int limit;
  private ListNode<K, V> head;
  private ListNode tail;
  // limit is the max capacity of the cache
  public Solution(int limit) {
    this.map = new HashMap<K, ListNode<K, V>>();
    this.limit = limit;
  }
  
  static class ListNode<K, V> {
    K key;
    V value;
    ListNode<K, V> prev;
    ListNode<K, V> next;
    
    ListNode(K key, V value) {
      this.key = key;
      this.value = value;
    }
    
    void update(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }
  
  public void set(K key, V value) {
    ListNode node = null;
    if (map.containsKey(key)) {
      node = map.get(key);
      remove(node);
      node.value = value;
    } else if (map.size() < limit) {
      node = new ListNode<K, V>(key, value);
    } else {
      node = tail;
      remove(node);
      node.update(key, value);
    }
    append(node);
  }
  
  private ListNode<K, V> remove(ListNode<K, V> node) {
    map.remove(node.key);
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
  
  private ListNode<K, V> append(ListNode<K, V> node) {
    map.put(node.key, node);
    if (head == null) {
      head = tail = node;
    } else {
      node.next = head;
      head.prev = node;
      head = node; 
    }
    return node;
  }
  
  public V get(K key) {
    ListNode<K, V> node = map.get(key);
    if (node == null) {
      return null;  
    }
    remove(node);
    append(node);
    return node.value;
  }
}

