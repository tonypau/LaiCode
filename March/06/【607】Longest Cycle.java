// tc: O(n) amortized 
// sc: O(n)

public class Solution {
  public int longest(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    int max = 0;
    int[] dp = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      dp[i] = helper(dp, nums, i);
      max = Math.max(max, dp[i]);
    }
    return max;
  }

  private int helper(int[] dp, int[] nums, int i) {
    int num = nums[i];
    int tmp = nums[i];
    int count = 1;
    while (num != nums[tmp]) {
      count++;
      if (dp[tmp] != 0) {
        return dp[tmp];
      }
      tmp = nums[tmp];
    }
    return count;
  }
}

