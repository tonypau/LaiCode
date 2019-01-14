public class Solution {
  public LinkedList<Integer> s1 = new LinkedList<>();
  public LinkedList<Integer> s2 = new LinkedList<>();
  
  public Solution() {
  }
  
  public Integer poll() {
    if (isEmpty()) return null;
    if (s2.isEmpty()) {
      while (!s1.isEmpty()) s2.offerLast(s1.pollLast());
    }
    return s2.pollLast();
  }
  
  public void offer(int element) {
    s1.offerLast(element);
  }
  
  public Integer peek() {
    if (isEmpty()) return null;
    if (s2.isEmpty()) {
      while (!s1.isEmpty()) s2.offerLast(s1.pollLast());
    }
    return s2.peekLast();
  }
  
  public int size() {
    return s1.size() + s2.size();
  }
  
  public boolean isEmpty() {
    return size() == 0;
  }
}

