/*
Find the greatest common factor of two positive integers.

Examples:

a = 12, b = 18, the greatest common factor is 6, since 12 = 6 * 2, 18 = 6 * 3.
a = 5, b = 16, the greatest common factor is 1.
*/

public class Solution {
  public int gcf(int a, int b) {
    if (b/a * a == b) return a;
    if (a/b * b == a) return b;
    if (a < b) {
      return helper(a, b);
    } else {
      return helper(b, a);
    }
  }
  
  private int helper(int a, int b) {
    int res = a / 2;
    while (a > 1) {
      if (a / res * res == a && b / res * res == b) {
        return res;
      } else {
        res--;
      }
    }
    return a;
  }
}

