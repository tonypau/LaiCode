/*
[1]
Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.

Assumptions

A is not null
Examples
Input: A = {5, 2, 6, 3, 4, 7, 5}
Output: 4
Because [2, 3, 4, 5] is the longest ascending subsequence.
*/

// O(nlogn)
// A = {5,    2,    6,    3,    4,    7,   5}
// M = {1,    1,    2,    2,    3,    4,   4}
     discard     discard           discard
// 3 key insights:
// 1) when two elements with the same m value, we keep the one with smaller A value
// 2) based on 1), we can find if index <a, m> is a simplified candidate, 
    the A value must be the smallest ending of all ascending subsequence with length m
// 3) based on 2), we can find if two candidates <A[j1], M[j1]>, <A[j2], M[j2]> are both simplified candidates, 
    if M[j1] < M[j2], then A[j1] < A[j2].
public class Solution {
  public int longest(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }
    // refine is sorted
    // so we can apply binary search on refine
    int[] refine = new int[array.length + 1];
    refine[1] = array[0];
    int res = 1;
    for (int i = 1; i < array.length; i++) {
      int index = binarySearch(refine, 1, res, array[i]);
      if (res == index) {
        refine[++res] = array[i];
      } else {
        refine[index + 1] = array[i];
      }
    }
    return res;
  }
  
  private int binarySearch(int[] array, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return right;
  }
}
