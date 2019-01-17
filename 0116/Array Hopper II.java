public class Solution {
  public int minJump(int[] array) {
    int[] m = new int[array.length];
    for (int i = 0; i < m.length - 1; i++) {
      m[i] = -1;
    }
    m[array.length - 1] = 0;
    for (int i = array.length - 2; i >= 0; i--) {
      int min = Integer.MAX_VALUE;
      for (int j = array[i]; j >= 0; j--) {
        if (i + j < array.length && m[i + j] != -1) {
          min = Math.min(min, m[i + j] + 1);
        }
      }
      m[i] = min == Integer.MAX_VALUE ? -1 : min;
    }
    return m[0];
  }
}

