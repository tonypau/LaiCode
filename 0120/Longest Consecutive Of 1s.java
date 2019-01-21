public class Solution {
  public int longest(int[] array) {
    if (array.length == 0) return 0;
    int cur = 0;
    int max = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == 1) {
        cur++;
        max = Math.max(max, cur);
      } else {
        cur = 0;
      }
    }
    return max;
  }
}

