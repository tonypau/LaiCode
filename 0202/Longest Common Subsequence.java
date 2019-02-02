public class Solution {
  public int longest(String source, String target) {
    int[][] dp = new int[target.length() + 1][source.length() + 1];
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (source.charAt(j - 1) == target.charAt(i - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[dp.length - 1][dp[0].length - 1];
  }
}

