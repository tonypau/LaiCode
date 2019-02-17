// Implement a stack by using one queue,  assuming we can get the size of the queue at any time
// O(n) every pop() or top()
public class Solution {
  LinkedList<Integer> q1;
  public Solution() {
    q1 = new LinkedList<Integer>();
  }

  public Integer pop() {
    for (int i = 0; i < size() - 1; i++) {
      q1.offerLast(q1.pollFirst());
    }
    return q1.pollFirst();
  }

  public Integer top() {
    for (int i = 0; i < size() - 1; i++) {
      q1.offerLast(q1.pollFirst());
    }
    int res = q1.peekFirst();
    q1.offerLast(q1.pollFirst());
    return res;
  }

  public void push(int element) {
    q1.offerLast(element);
  }

  public boolean isEmpty() {
    return size() == 0;
  }
}
