public class Solution {
  public int missing(int[] array) {
    int N = array.length + 1;
    int res = 0;
    for (int i = 1; i <= N; i++) {
      res ^= i;
    }
    for (int i : array) {
      res ^= i;
    }
    return res;
  }
}

