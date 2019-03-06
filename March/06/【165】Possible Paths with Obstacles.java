// tc: O(n^2)
// sc: O(n^2)

// dp[i][j]: possible paths from top-left to [i][j]
// dp[i][j] = 0,                             if arr[i][j] is obstacle   
//           = 1,                             if [i][j] is at side
//           = dp[i - 1][j] + dp[i][j - 1],   otherwise

public class Solution {
  public int possiblepath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix[0][0] == 1) return 0;
    int M = matrix.length;
    int N = matrix[0].length;
    int[][] dp = new int[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (matrix[i][j] == 1) {
          dp[i][j] = 0;
        } else if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }
    return dp[M - 1][N - 1];
  }
}

