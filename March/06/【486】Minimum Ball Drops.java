// https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
//  dp(n, k) ==> Minimum number of trials needed to find the critical
//                    floor in worst case.
//  dp(n, k) = 1 + min{max(dp(n - 1, x - 1), dp(n, k - x)): 
//                 x in {1, 2, ..., k}}
public class Solution {
  public int getMinDrops(int B, int M) {
    int[][] dp = new int[B + 1][M + 1];
    for (int i = 1; i <= B; i++) { 
      dp[i][1] = 1; 
      dp[i][0] = 0; 
    } 
    for (int i = 1; i <= M; i++) {
      dp[1][i] = i;
    }
    // Fill rest of the entries in table using optimal substructure 
    // property 
    int res;
    for (int i = 2; i <= B; i++) { 
      for (int j = 2; j <= M; j++) { 
        dp[i][j] = Integer.MAX_VALUE; 
        for (int x = 1; x <= j; x++) { 
          res = 1 + Math.max(dp[i-1][x-1], dp[i][j-x]); 
          dp[i][j] = Math.min(dp[i][j], res); 
        } 
      } 
    } 
    return dp[B][M];
  }
}
