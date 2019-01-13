public class Solution {
  public long fibonacci(int K) {
    if (K <= 0) return 0;
    if (K == 1) return 1;
    long a = 0;
    long b = 1;
    for (int i = 2; i <= K; i++) {
      long tmp = a + b;
      a = b;
      b = tmp;
    }
    return b;
  }
}
