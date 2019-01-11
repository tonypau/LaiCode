/*
[249]. similar with [290][Wildcard matching]
Implement regular expression matching with support for '.' and '*'. '.' Matches any single character. '*' Matches zero or more of the preceding element. The matching should cover the entire input string (not partial).

Example

isMatch("aa","a") → false

isMatch("aa","aa") → true

isMatch("aaa","aa") → false

isMatch("aa", "a*") → true

isMatch("aa", ".*") → true

isMatch("ab", ".*") → true

isMatch("aab", "c*a*b") → true
*/


// dp[i][j] means whether the first i characters of input matches the first j characters of pattern
public class Solution {
  public boolean isMatch(String input, String pattern) {
    int m = input.length();
    int n = pattern.length();
    if (n == 0) return m == 0;
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    // initialization
    for (int i = 1; i <= n; i++) {
      if (pattern.charAt(i - 1) == '*' && dp[0][i - 2]) {
        dp[0][i] = true;
      }
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (pattern.charAt(j - 1) == input.charAt(i - 1) || pattern.charAt(j - 1) == '.') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (pattern.charAt(j - 1) == '*') {
        // two possibilities
          if (pattern.charAt(j - 2) != input.charAt(i - 1) && pattern.charAt(j - 2) != '.') {
          // first: 
          // s:  .....c
          // p:  ....b*
          // b != c, only way to match is ignore b, repeat b 0 times
            dp[i][j] = dp[i][j - 2];
          } else {
          // second:
          //         i
          // s: .....a
          // p: ....a*
          //         j
          // 3 choices to match:
          // 1) let first i-1 characters of s match the first j characters of p: * means a repeat multiple times
          // 2) let first i characters of s match the first j-1 characters of p: * means a repeat 1 time
          // 3) let first i characters of s match the first j-2 characters of p: * means a repeat 0 times
            dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
          }
        }
      }
    }
    return dp[m][n];
  }
}

