public class Solution {
  public LinkedList<Integer> stack = new LinkedList<>();
  // record possible min value so far
  public LinkedList<Integer> minStack = new LinkedList<>();
  
  public Solution() {
  }
  
  public int pop() {
    if (stack.isEmpty()) return -1;
    // NOTICE: should use equals() here. because comparing two Integer objects. if using ==, that definitely return false
    if (minStack.peekLast().equals(stack.peekLast())) minStack.pollLast();
    return stack.pollLast();
  }
  
  public void push(int element) {
    stack.offerLast(element);
    if (minStack.isEmpty() || minStack.peekLast() >= element) {
      minStack.offerLast(element);
    }
  }
  
  public int top() {
    if (stack.isEmpty()) return -1;
    return stack.peekLast();
  }
  
  public int min() {
    if (minStack.isEmpty()) return -1;
    return minStack.peekLast();
  }
}
