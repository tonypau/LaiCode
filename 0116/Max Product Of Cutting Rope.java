public class Solution {
  public int maxProduct(int length) {
    int[] m = new int[length + 1];
    for (int i = 2; i < m.length; i++) {
      for (int j = 1; j < i; j++) {
      // 左大段，右小段
        m[i] = Math.max(m[i], Math.max(j, m[j]) * (i - j));
      }
    }
    return m[length];
  }
}
