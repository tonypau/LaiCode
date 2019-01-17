public class Solution {
  public boolean canJump(int[] array) {
    boolean[] m = new boolean[array.length];
    m[array.length - 1] = true;
    for (int i = array.length - 2; i >= 0; i--) {
      for (int j = 1; j <= array[i]; j++) {
        // due to the property of ||, we do not need to [check i + j < array.length] any more
        m[i] = m[i] || m[i + j];
      }
    }
    return m[0];
  }
}

