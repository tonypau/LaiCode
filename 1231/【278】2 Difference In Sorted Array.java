/*
Given a sorted array A, find a pair (i, j) such that A[j] - A[i] is identical to a target number(i != j).

If there does not exist such pair, return a zero length array.

Assumptions:

The given array is not null and has length of at least 2.
Examples:

A = {1, 2, 3, 6, 9}, target = 2, return {0, 2} since A[2] - A[0] == 2.
A = {1, 2, 3, 6, 9}, target = -2, return {2, 0} since A[0] - A[2] == 2.
*/

/*
  two pointers.
  O(n)
*/
public class Solution {
  public int[] twoDiff(int[] array, int target) {
    // consider in two ways. positive and negative target. because the result of pair has requirements of index order 
    if (target >= 0) {
      int i = array.length - 1;
      int j = i - 1;
      while (i >= 0 && j >= 0) {
        if (i != j && array[i] - array[j] == target) {
          if (array[i] == array[j]) {
            return new int[]{Math.min(i, j), Math.max(i, j)};
          }
          return new int[]{j, i};
        } else if (array[i] - array[j] < target) {
          j--;
        } else {
          i--;
        }
      }
    } else {
      int i = 0;
      int j = 1;
      int n = array.length;
      while (i < n && j < n) {
        if (i != j && (array[i] - array[j] == target)) {
          if (array[i] == array[j]) {
            return new int[]{Math.min(i, j), Math.max(i, j)};
          }
          return new int[]{j, i};
        } else if (array[i] - array[j] < target) {
          i++;
        } else {
          j++;
        }
      }
    }
    return new int[0];
  }
}

