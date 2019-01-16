public class Solution {
  public int diffBits(int a, int b) {
    a ^= b;
    int res = 0;
    while (a != 0) {
      if ((a & 1) == 1) res++;
      a >>>= 1;
    }
    return res;
  }
}

