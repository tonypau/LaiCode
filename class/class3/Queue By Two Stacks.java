/*
  s1: store new elements
  s2: return elements
    case1: when s2 is not empty, we just pop out from s2                          ----- O(1)
    case2: when s2 is empty, we need to pop out all elements from s1 to s2        ----- O(n)
    
  Amotized time complexity: O(1)
*/

public class Solution {
  LinkedList<Integer> s1;
  LinkedList<Integer> s2;
  
  public Solution() {
    // Write your solution here.
    s1 = new LinkedList<Integer>();
    s2 = new LinkedList<Integer>();
  }
  
  public Integer poll() {
    if (s2.isEmpty()) {
      move();
    }
    return s2.pollLast();
  }
  
  public void offer(int element) {
    s1.offerLast(element);
  }
  
  public Integer peek() {
    if (s2.isEmpty()) {
      move();
    }
    return s2.peekLast();
  }
  
  public int size() {
    return s1.size() + s2.size();
  }
  
  public boolean isEmpty() {
    return size() == 0;
  }
  
  private void move() {
    while (!s1.isEmpty()) {
      s2.offerLast(s1.pollLast());
    }
  }
}

