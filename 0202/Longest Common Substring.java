public class Solution {
  public String longestCommon(String source, String target) {
    int[][] dp = new int[target.length() + 1][source.length() + 1];
    String res = "";
    int max = 0;
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        if (source.charAt(j - 1) == target.charAt(i - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
          if (max < dp[i][j]) {
            max = dp[i][j];
            res = source.substring(j - max, j);
          }
        } 
      }
    }
    return res;
  }
}
