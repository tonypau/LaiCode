// data structure: stack
// when meeting a higher one, we just add its index into stack
// when meeting a lower one, we pop the top one in stack and update the result

//tc: O(n)
//sc: O(n)
public class Solution {
  public int largest(int[] array) {
    Deque<Integer> stack = new LinkedList<>();
    int max = 0;
    for (int i = 0; i < array.length + 1; i++) {
      int cur = i == array.length ? 0 : array[i];        // tricky
      while (!stack.isEmpty() && cur <= array[stack.peekLast()]) {
      /*  my wrong version
        int left = stack.pollLast(); // wrong. Because when the last one and also the only one in stack is not 0, left should be 0.
        int height = array[left];
        int length = i - left;
        max = Math.max(max, height * length);
      */
        int height = array[stack.pollLast()];
        int left = stack.isEmpty() ? 0 : stack.peekLast() + 1;  // tricky. 
        max = Math.max(max, height * (i - left));
      }
      stack.offerLast(i);
    }
    return max;
  }
}

