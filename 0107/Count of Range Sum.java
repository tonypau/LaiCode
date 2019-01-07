/*
【461】
Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
*/


// average O(nlogn)
public class Solution {
  public int countRangeSum(int[] nums, int lower, int upper) {
    if (nums == null || nums.length == 0) return 0;
    long[] sums = new long[nums.length];  
    sums[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      sums[i] = sums[i - 1] + nums[i];
    }
    
    // find j and i (j < i) in prefix sum array
    // lower <= sums[i] - sums[j] <= upper,
    // that is, count of sums[j] which is in the range of sums[i] - upper <= sums[j] <= sums[i] - lower
    TreeMap<Long, Integer> map = new TreeMap<>();
    map.put(0L, 1);
    int count = 0;
    for (int i = 0; i < sums.length; i++) {
      long left = sums[i] - upper;
      long right = sums[i] - lower;
      for (int c : map.subMap(left, true, right, true).values()) {
        count += c;
      }
      if (map.containsKey(sums[i])) {
        map.put(sums[i], map.get(sums[i]) + 1);      
      } else {
        map.put(sums[i], 1);
      }
    }
    return count;
  }
}
