public class Solution {
  public int largest(int[] array) {
    int res = 0;
    Deque<Integer> stack = new LinkedList<>();

    // i exclusive, so can be array.length.
    for (int i = 0; i <= array.length; i++) {
      int cur = i == array.length ? 0 : array[i];
      while (!stack.isEmpty() && array[stack.peekLast()] >= cur) {
        int height = array[stack.pollLast()];
        int left = stack.isEmpty() ? 0 : stack.peekLast() + 1;
        res = Math.max(res, height * (i - left));
      }
      stack.offerLast(i);
    }
    return res;
  }
}

