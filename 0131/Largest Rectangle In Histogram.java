// O(n)
// linear scan，回头看
// 保持stack非单调递减
public class Solution {
  public int largest(int[] array) {
    Deque<Integer> stack = new LinkedList<>();
    int max = 0;
    for (int i = 0; i <= array.length; i++) {
      int cur = i == array.length ? 0 : array[i];
      while (!stack.isEmpty() && cur <= array[stack.peekLast()]) {
        int height = array[stack.pollLast()];
        int left = stack.isEmpty() ? 0 : stack.peekLast() + 1;
        max = Math.max(max, height * (i - left));
      }
      stack.offerLast(i);
    }
    return max;
  }
}
