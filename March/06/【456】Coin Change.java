// tc: O(m*n) m is the length of coins
// sc: O(n)
public class Solution {
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    for (int i = 1; i < dp.length; i++) {
      dp[i] = Integer.MAX_VALUE;
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] > i) {
          break;
        } else {
          if (dp[i - coins[j]] == Integer.MAX_VALUE) {
            continue;
          } else {
            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
          }
        }
      }
    }
    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
  }
}

