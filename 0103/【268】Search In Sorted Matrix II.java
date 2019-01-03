/*
Given a 2D matrix that contains integers only, which each row is sorted in ascending order and each column is also sorted in ascending order.

Given a target number, returning the position that the target locates within the matrix. If the target number does not exist in the matrix, return {-1, -1}.

Assumptions:

The given matrix is not null.
Examples:

matrix = { {1, 2, 3}, {2, 4, 5}, {6, 8, 10} }

target = 5, return {1, 2}

target = 7, return {-1, -1}
*/

public class Solution {
  public int[] search(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[] {-1, -1};
    int M = matrix.length;
    int N = matrix[0].length;
    int left = 0;
    int right = M - 1;
    int row = -1;
    // 1st binary search: find the last row that the target may possibly sexits
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (target == matrix[mid][0]) {
        return new int[] {mid, 0};  
      } else if (matrix[mid][0] > target) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    row = right;
    // for loop all possible row, do binary serach each to find the target.
    for (int i = 0; i <= row; i++) {
      int l = 0;
      int r = N - 1;
      while (l <= r) {
        int mid = l + (r - l) / 2;
        if (target == matrix[i][mid]) {
          // due to the answer needs to be the first appearance, so directly return.
          return new int[] {i, mid};
        } else if (target > matrix[i][mid]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
    }
    return new int[] {-1, -1};
  }  
}
