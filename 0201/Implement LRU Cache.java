// There are four use cases needed to be considered:
// 1) return the corresponding value of specific K     (HashMap)
// 2) insert new K                                  ->
// 3) remove oldest K                               ->  ListNode链表，方便插入删除
// 4) update timestamp of previous K                ->

public class Solution<K, V> {
  // limit is the max capacity of the cache
  Map<K, ListNode> map;
  final int limit;
  ListNode head;
  ListNode tail;
  public Solution(int limit) {
    this.map = new HashMap<K, ListNode>();
    this.limit = limit;
    this.head = null;
    this.tail = null;
  }

  static class ListNode<K, V> {
    V value;
    K key;
    ListNode prev;
    ListNode next;
    ListNode(K key, V value) {
      this.key = key;
      this.value = value;
      this.prev = null;
      this.next = null;
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
      node.value = value;
      remove(node);
    } else if (map.size() < limit) {
      node = new ListNode<K, V>(key, value);
    } else {
      node = tail;
      remove(node);
      node.update(key, value);
    }
    append(node);
  }
  
  public ListNode<K, V> remove(ListNode<K, V> node) {
    map.remove(node.key);
    if (node.prev != null) {
      node.prev.next = node.next;
    }
    if (node.next != null) {
      node.next.prev = node.prev;
    }
    if (node == head) {
      head = node.next;
    }
    if (node == tail) {
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

