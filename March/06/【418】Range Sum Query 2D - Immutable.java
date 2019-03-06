public class Solution {
  public int sumRegion(int[][] matrix, int row1, int col1, int row2, int col2) {
    if (matrix == null || matrix.length == 0) return 0;
    int[][] dp = init(matrix);
    if (row1 == 0 && row2 == 0) {
      return dp[row2][col2]; 
    } else if (row1 == 0) {
      return dp[row2][col2] - dp[row2][col1 - 1];
    } else if (col1 == 0) {
      return dp[row2][col2] - dp[row2 - 1][col1];
    } else {
      return dp[row2][col2] - dp[row2][col1 - 1] - dp[row1 - 1][col2] + dp[row1 - 1][col1 - 1];
    }
  }
  
  private int[][] init(int[][] matrix) {
    int M = matrix.length;
    int N = matrix[0].length;
    int[][] dp = new int[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = matrix[i][j];
        } else if (i == 0) {
          dp[i][j] = dp[i][j - 1] + matrix[i][j];
        } else if (j == 0) {
          dp[i][j] = dp[i - 1][j] + matrix[i][j];
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
        }
      }
    }
    return dp;
  }
}
