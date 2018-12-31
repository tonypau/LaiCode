// recursive. add offset (help with recursion rule) and size (help with base case)

public class Solution {
  public int[][] spiralGenerate(int n) {
    int[][] res = new int[n][n];
    helper(res, n, 0, 1);
    return res;
  }
  
  private void helper(int[][] res, int size, int offset, int count) {
    if (size == 0) {
      return;
    }
    if (size == 1) {
      res[offset][offset] = count;
      return;
    }
    int m = res.length - 1 - offset;
    for (int i = offset; i < m; i++) {
      res[offset][i] = count++;
    }
    for (int i = offset; i < m; i++) {
      res[i][m] = count++;
    }
    for (int i = m; i > offset; i--) {
      res[m][i] = count++; 
    }
    for (int i = m; i > offset; i--) {
      res[i][offset] = count++;
    }
    helper(res, size - 2, offset + 1, count);
  }
}
