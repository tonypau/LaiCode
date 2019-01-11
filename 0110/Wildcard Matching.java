/*
[290]
Given two strings where first string is a normal string and second string may contain wild card characters.
Write a function that returns true if the two strings match. The following are allowed wildcard characters in first string. 
* --> Matches with 0 or more instances of any character or set of characters.
? --> Matches with any one character.

Assumptions:

The two strings are both not null.
Assume there is no more than one '*' adjacent to each other.
Examples:

input = "abc", pattern = "?*", return true.
*/

// dp[i][j] means whether the first i characters of input matches the first j characters of pattern
public class Solution {
  public boolean match(String input, String pattern) {
    int m = input.length();
    int n = pattern.length();
    if (n == 0) return m == 0;
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int i = 1; i <= n; i++) {
      if (pattern.charAt(i - 1) == '*') {
        dp[0][i] = dp[0][i - 1];
      }
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (pattern.charAt(j - 1) == '?' || pattern.charAt(j - 1) == input.charAt(i - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (pattern.charAt(j - 1) == '*') {
        // if we encounter '*', two choices are possible.
        // 1) because the ith characters of input can be matched with the jth character '*' in pattern,
        //    so if the first i-1 characters in input matches the first j characters in pattern, then dp[i][j] is true 
        // 2) because '*' can also mean space, 
        //    so if the first i characters in input matches the first j-1 characters in pattern, then dp[i][j] is true
          dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
        } else {
          dp[i][j] = false;
        }
      }
    }
    return dp[m][n];
  }
}
