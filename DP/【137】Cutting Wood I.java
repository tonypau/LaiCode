// TC: O(n^3)
// SC: O(n^2)
// cuts = [2, 4, 7]
//     |_ _|_ _|_ _ _|_ _ _|
//     0   2   4     7     10      helper[]
//     0   1   2     3     4       index of helper
//     j   k               i
// dp rule: dp[j][i] = min(dp[j][k] + dp[k][i]) + helper[j] - helper[i]
public class Solution {
  public int minCost(int[] cuts, int length) {
    int[] helper = new int[cuts.length + 2];
    helper[0] = 0;
    for (int i = 0; i < cuts.length; i++) {
      helper[i + 1] = cuts[i];
    }
    helper[helper.length - 1] = length;
    int[][] dp = new int[helper.length][helper.length];
    for (int i = 1; i < dp.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (j + 1 == i) {
          dp[j][i] = 0;
        } else {
          dp[j][i] = Integer.MAX_VALUE;
          for (int k = j + 1; k < i; k++) {
            dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k][i]);
          }
          dp[j][i] += helper[i] - helper[j];
        }
      }
    }
    return dp[0][helper.length - 1];
  }
}
