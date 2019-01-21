// 2d dp using in string problem
public class Solution {
  public int editDistance(String one, String two) {
    if (one.length() == 0) return two.length();
    if (two.length() == 0) return one.length();
    int[][] dp = new int[one.length() + 1][two.length() + 1];
    for (int i = 0; i <= one.length(); i++) {
      for (int j = 0; j <= two.length(); j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = 0;
        } else if (i == 0) {
          dp[i][j] = j;
        } else if (j == 0) {
          dp[i][j] = i;
        } else {
          if (one.charAt(i - 1) == two.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1];
          } else {
            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
          }
        }
      }
    }
    return dp[one.length()][two.length()];
  }
}

