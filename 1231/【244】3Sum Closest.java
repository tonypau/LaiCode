/*
  Description
  Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
  Return the sum of the three integers. You may assume that each input would have exactly one solution.

  Example

      For example, given array S = {-1 2 1 -4}, and target = 1.

      The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

// similar to the problem of 3sum smaller. the point is how to move left and right
public class Solution {
  public int threeSumClosest(int[] num, int target) {
    if (num.length < 3) return -1;
    Arrays.sort(num);
    int diff = Integer.MAX_VALUE;
    int res = 0;
    for (int i = 0; i < num.length - 1; i++) {
      int left = i + 1;
      int right = num.length -1;
      while (left < right) {
        int sum = num[i] + num[left] + num[right];
        int cur_diff = Math.abs(target - sum);
        if (cur_diff < diff) {
          res = sum;
          diff = cur_diff;
        }
        if (sum < target) {
          left++;
        } else {
          right--;
        }
      }
    }
    return res;
  }
}
