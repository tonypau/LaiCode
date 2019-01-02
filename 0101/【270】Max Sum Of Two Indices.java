/*
Given an array with integers, find two indices i and j  (j>=i),  such that the value of A[i]+A[j]+ (j - i) is maximized.

Return (i, j).

Assumptions:

The given array is not null and it has length of > 0.
Examples:

array = {1, 5, 3}, the max sum is array[1] + array[1] + (1 - 1) = 10, return {1, 1}
*/

// O(n)
// divide into two part
public class Solution {
  public int[] maxSum(int[] array) {
    // max of A[i] - i
    int max_i = Integer.MIN_VALUE;
    int index_i = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] - i > max_i) {
        index_i = i;
        max_i = array[i] - i;
      }
    }
    // max of A[j] + j
    int max_j = Integer.MIN_VALUE;
    int index_j = 0;
    for (int j = 0; j < array.length; j++) {
      if (array[j] + j > max_j) {
        index_j = j;
        max_j = array[j] + j;
      }
    }
    return new int[]{index_i, index_j};
  }
}

