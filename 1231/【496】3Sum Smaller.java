/*
  Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n 
    that satisfy the condition nums[i] + nums[j] + nums[k] < target.

  For example, given nums = [-2, 0, 1, 3], and target = 2.

  Return 2. Because there are two triplets which sums are less than 2:

  [-2, 0, 1]
  [-2, 0, 3]
*/

// O(n^2)
public class Solution {
  public int threeSumSmaller(int[] num, int target) {
    if (num.length < 3) {
      return 0;
    }  
    Arrays.sort(num);
    int res = 0;
    for (int i = 0; i < num.length - 1; i++) {
      int left = i + 1;
      int right = num.length - 1;
      while (left < right) {
        if (num[i] + num[left] + num[right] < target) {
          // NOTICE. when num[right] added < target, then addng a value less than num[right] still be < target.
          // so res += right - left;
          res += right - left;
          left++;
        } else {
          right--;
        }
      }
    }
    return res;
  }
}
