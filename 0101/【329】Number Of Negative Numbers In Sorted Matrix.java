public class Solution {
  // O(m + n): rightmost to leftmost and topmost to bottommost
  public int negNumber(int[][] matrix) {
    int count = 0;
    int N = matrix.length;
    int M = matrix[0].length;
    int i = 0;
    int j = M - 1;
    while (j >= 0 && i < N) {
      if (matrix[i][j] < 0) {
        count += j + 1;
        i++;
      } else {
        j--;
      }
    }
    return count;
  }
}
