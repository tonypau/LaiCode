/*
  Use 3 stacks.
 
  left.add()    O(1)
  right.add()   O(1)
   
  left.remove() 
  right.remove()
    case1: when left or right is not empty, just pop out.   O(1)
    case2: when left or right is empty, we need to take half out from another side stack and also need to maintain the order of elements.  O(n)
  
  Amortized time complexity:   (6* n/2 + 1* n/2) / n/2 = O(1)
    the first call left.remove():
      n/2 pop from right
      n/2 push into buffer
      n/2 pop from right
      n/2 push into left
      n/2 pop from buffer
      n/2 push into right
    
    Up to next n/2 remove takes 1 operations each
    
*/

public class Solution {
  LinkedList<Integer> left;
  LinkedList<Integer> right;
  LinkedList<Integer> buffer;
  
  public Solution() {
    left = new LinkedList<Integer>();
    right = new LinkedList<Integer>();
    buffer = new LinkedList<Integer>();
  }
  
  public void offerFirst(int element) {
    left.push(element);
  }
  
  public void offerLast(int element) {
    right.push(element);
  }
  
  public Integer pollFirst() {
    if (left.isEmpty()) {
      shuffle(right, left);
    }
    return left.pop();
  }
  
  public Integer pollLast() {
    if (right.isEmpty()) {
      shuffle(left, right);
    }
    return right.pop();
  }
  
  private void shuffle(LinkedList<Integer> s1, LinkedList<Integer> s2) {
    int size = s1.size();
    for (int i = 0; i < size / 2; i++) {
      buffer.push(s1.pop());
    }
    for (int i = 0; i < size - size / 2; i++) {
      s2.push(s1.pop());
    }
    for (int i = 0; i < size / 2; i++) {
      s1.push(buffer.pop());
    }
  }
}
