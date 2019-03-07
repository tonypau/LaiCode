// tc: O(n) amortized 
// sc: O(n)

public class Solution {
  public int longest(int[] nums) {
    int max = 0;
    int[] dp = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      helper(dp, nums, i);
      max = Math.max(max, dp[i]);
    }
    return max;
  }

  private void helper(int[] dp, int[] nums, int i) {
    int num = nums[i];
    int tmp = nums[i];
    int count = 1;
    List<Integer> list = new ArrayList<>();
    list.add(i);
    while (num != nums[tmp]) {
      count++;
      if (dp[tmp] != 0) {
        dp[i] = dp[tmp];
        return;
      }
      list.add(tmp);
      tmp = nums[tmp];
    }
    for (int index : list) {
      dp[index] = count;
    }
  }
}

