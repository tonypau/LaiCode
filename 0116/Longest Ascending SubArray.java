public class Solution {
  public int longest(int[] array) {
    if (array == null || array.length == 0) return 0;
    int m = 1;
    int max = 1;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > array[i - 1]) {
        m++;
      } else {
        m = 1;
      }
      max = Math.max(m, max);
    }
    return max;
  }
}

