/*
[19]
Given a target integer T, a non-negative integer K and an integer array A sorted in ascending order, find the K closest numbers to T in A.

Assumptions

A is not null
K is guranteed to be >= 0 and K is guranteed to be <= A.length
Return

A size K integer array containing the K closest numbers(not indices) in A, sorted in ascending order by the difference between the number and T. 
Examples

A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}
*/

public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    if (array == null || array.length == 0 || k == 0) return new int[0];
    // find the index of the closest element to target
    int index = getClosest(array, target);
    int[] res = new int[k];
    int left = index - 1;
    int right = index + 1;
    res[0] = array[index];
    // two pointers towards two directions
    for (int i = 1; i < k; i++) {
      if (left >= 0 && right < array.length) {
        res[i] = Math.abs(array[left] - target) <= Math.abs(array[right] - target) ? array[left--] : array[right++];
      } else if (left >= 0) {
        res[i] = array[left--];
      } else {
        res[i] = array[right++];
      }
    }
    return res;
  }
  
  private int getClosest(int[] array, int target) {
    if (array == null || array.length == 0) return -1;
    int left = 0;
    int right = array.length -1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;  
      } else if (array[mid] > target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    if (Math.abs(array[left] - target) <= Math.abs(array[right] - target)) return left;
    else return right;
  }
}

