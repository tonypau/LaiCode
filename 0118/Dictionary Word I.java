// 左大段+右小段
// 左大段: check former dp value in the table, directly read dp[i]
// 右小段: not read table, directly manual manipulation from the problem set

// 左大段+右小段思想 is more general than 左大段+右大段思想 
// because it applies to the case where the 最小可分元素 is similar but not identical
public class Solution {
  public boolean canBreak(String input, String[] dict) {
    Set<String> set = new HashSet<>();
    for (String s : dict) set.add(s);
    boolean[] dp = new boolean[input.length() + 1];
    dp[0] = true;
    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[j] && set.contains(input.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[dp.length - 1];
  }
}

