// tc: O(n^2)
// sc: O(n^2)

// dp[i][j]: the minimum sum path from top-left to arr[i][j]
// dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + arr[i][j]

public class Solution {
  public int miniSum(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    int[][] dp = new int[grid.length][grid[0].length];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = grid[i][j];
        } else if (i == 0) {
          dp[i][j] = dp[i][j - 1] + grid[i][j];
        } else if (j == 0) {
          dp[i][j] = dp[i - 1][j] + grid[i][j];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]; 
        }
      }
    }
    return dp[grid.length - 1][grid[0].length - 1];
  }
}

