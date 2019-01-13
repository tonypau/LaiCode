// O(logb)
public class Solution {
  public long power(int a, int b) {
    if (a == 0) return 0;
    if (b == 0) return 1;
    long result;
    if (b % 2 == 0) {
      result = power(a, b / 2);
      return result * result;
    } else {
      result = power(a, b / 2);
      return result * result * a;
    }
  }
}
