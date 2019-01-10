/*
[434]
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery 
so that he will not get too much attention. This time, all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/

// divide into two parts due to the last one is the neighbour of the first one.
public class Solution {
  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
  }
  
  public int rob(int[] num, int lo, int hi) {
    int include = 0;
    int exclude = 0;
    for (int j = lo; j <= hi; j++) {
      int i = include;
      int e = exclude;
      exclude = Math.max(i, e);
      include = e + num[j];
    }
    return Math.max(exclude, include);
  }
}
