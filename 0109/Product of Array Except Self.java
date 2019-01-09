/*
[474]
Given an array of n integers where n > 1, nums, 
return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? 
(Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/

public class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] res = new int[nums.length];
    if (nums == null || nums.length == 0) return res;
    res[0] = 1;
    int sum = 1;
    int countOfZero = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        countOfZero++;
      } else {
        sum *= nums[i];
      }
      if (countOfZero > 1) return new int[nums.length];
      if (i == 0) continue;
      res[0] *= nums[i];
    }
    for (int i = 1; i < res.length; i++) {
      if (nums[i] == 0) {
        res[i] = sum;
        continue;
      }
      res[i] = res[0] / nums[i] * nums[0];
    }
    return res;
  }
}

// O(n)
// use the result array to be the memorization array

