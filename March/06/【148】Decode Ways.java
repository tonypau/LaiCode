// tc: O(n)
// sc: O(n)

// dp[i]: the possible ways that arr[0..i-1] can be decoded
// dp[i] = sum(dp[k] (if substring(k, i-1) can be decoded))  k is in [0..i - 1]
// 找公式的关键点在于怎么用小一号问题的解构建出大一号问题
public class Solution {
  public int numDecodeWay(String input) {
    Set<String> set = initSet();
    int[] dp = new int[input.length() + 1];
    dp[0] = 0;
    for (int i = 1; i <= input.length(); i++) {
      if (set.contains(input.substring(0, i))) {
        dp[i] += 1;
      }
      for (int j = 1; j < i; j++) {
        String s1 = input.substring(j, i);
        if (set.contains(s1)) {
          dp[i] += dp[j];
        } 
      }
    }
    return dp[input.length()];
  }
  
  private Set<String> initSet() {
    Set<String> set = new HashSet<>();
    for (int i = 1; i <= 26; i++) {
      set.add(String.valueOf(i));
    }
    return set;
  }
}

