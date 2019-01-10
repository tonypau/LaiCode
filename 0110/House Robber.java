/*
[LeetCode 198]

You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
*/

// O(n^2), O(n)
public int rob(int[] nums) {
  if (nums == null || nums.length == 0) return 0;
  int max = 0;
  int[] m = new int[nums.length];
  for (int i = 0; i < nums.length; i++) {
    if (i < 2) {
        m[i] = nums[i];   
    } else {
        for (int j = 0; j < i - 1; j++) {
            m[i] = Math.max(m[i], m[j] + nums[i]);
        }
    }
    max = Math.max(m[i], max);
  }
  return max;
}

// O(n), O(n)
public int rob(int[] num) {
    int[][] dp = new int[num.length + 1][2];
    for (int i = 1; i <= num.length; i++) {
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        dp[i][1] = num[i - 1] + dp[i - 1][0];
    }
    return Math.max(dp[num.length][0], dp[num.length][1]);
}

// O(n), O(1)
public int rob(int[] num) {
    int[][] dp = new int[num.length + 1][2];
    for (int i = 1; i <= num.length; i++) {
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        dp[i][1] = num[i - 1] + dp[i - 1][0];
    }
    return Math.max(dp[num.length][0], dp[num.length][1]);
}
