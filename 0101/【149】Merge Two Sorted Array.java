/*
Merge given amount of numbers from two sorted arrays.

Input: [1, 2, 3], 3, [2, 4, 6], 1

Output: [1,2, 2, 3]

*/

public class Solution {
  public int[] merge(int[] A, int m, int[] B, int n) {
    int[] res = new int[m + n];
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < m && j < n) {
      if (A[i] < B[j]) {
        res[k++] = A[i++];
      } else {
        res[k++] = B[j++];
      }
    }
    while (i < m) {
      res[k++] = A[i++];
    }
    while (j < n) {
      res[k++] = B[j++];
    }
    return res;
  }
}
