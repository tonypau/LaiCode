//dfs超时 O(2^n)

public class Solution {
  public int getAdjBCStringCount(int n, int k) {
    int[][] dp = new int[n + 1][k + 1];    
    dp[1][0] = 2;
    dp[2][0] = 3;
    dp[2][1] = 1;
    for (int i = 3; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (j == 0) {
          dp[i][j] = dp[i - 1][j] + dp[i - 2][j];
        } else {
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] + dp[i - 2][j] - dp[i - 2][j - 1];
        }
      }
    }
    return dp[n][k];
  }
}

/*
  k   0   1   2   3   4   5   6
n +----------------------------
1 |   2   0   0   0   0   0   0
2 |   3   1   0   0   0   0   0
3 |   5   2   1   0   0   0   0
4 |   8   5   2   1   0   0   0
5 |  13  10   6   2   1   0   0
6 |  21  20  13   7   2   1   0
7 |  34  38  29  16   8   2   1
The first column is the familiar Fibonacci sequence, and satisfies the recurrence relation f(n, 0) = f(n-1, 0) + f(n-2, 0)

The other columns satisfies the recurrence relation f(n, k) = f(n - 1, k) + f(n - 1, k - 1) + f(n - 2, k) - f(n - 2, k - 1)
*/
