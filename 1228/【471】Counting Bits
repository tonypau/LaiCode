/*
  0
  1
  1 2
  1 2 2 3
  1 2 2 3 2 3 3 4
  1 2 2 3 2 3 3 4 2 3 3 4 3 4 4 5
*/

public class Solution {
  public int[] countBits(int num) {
    if (num == 0) return new int[]{0};
    if (num == 1) return new int[]{0,1};
    int[] m = new int[num + 1];
    m[0] = 0;
    m[1] = 1;
    int log = log2(num * 1.0);
    int j = 2;
    int cur = 2;
    for (int i = 2; i <= log; i++) {
      int range = (int) Math.pow(2, i - 2);
      while (j <= num && j < range + cur) {
        m[j] = m[j - range];
        j++;
      }
      while (j <= num && j < cur * 2) {
        m[j] = m[j - cur / 2] + 1;
        j++;
      }
      cur *= 2;
    }
    return m;
  }
  
  private static int log2(double d) {
    return (int) (Math.log(d)/Math.log(2.0)) + 1;
  }
}

