/*
  The idea is:
    1. the last bit of one odd AND one even is always 0
    2. only when m == n, there will not exist one odd and one even
    3. move m and n right a position
*/

public class Solution {
  public int rangeBitwiseAnd(int m, int n) {
    // Write your solution here
    if (m == 0) {
      return 0;
    }
    int moveFactor = 0;
    while (m != n) {
      m >>= 1;
      n >>= 1;
      moveFactor++;
    }
    return m <<= moveFactor;
  }
}
