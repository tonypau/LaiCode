/*
Given a 2D integer matrix, where every row is sorted in ascending order. How to find a common element in all rows. If there is no common element, then returns -1.

Example

matrix = { { 1, 2, 3, 4 }, { 4, 5, 6, 7 }, { 2, 3, 4, 8 } }

the common element is 4.
*/

// O(mn)
public class Solution {
  public int search(int[][] matrix) {
    int M = matrix.length; // row
    if (M <= 1) return -1;
    int min = Integer.MAX_VALUE;
    // column: initialize current last element of all rows
    int[] column = new int[M];
    for (int i = 0; i < column.length; i++) {
      column[i] = matrix[i].length - 1;
    }
    // initialize first row as first row
    int min_row = 0;
    while (column[min_row] >= 0) {
      // find minimize element in current last column
      for (int i = 0; i < M; i++) {
        if (matrix[i][column[i]] < matrix[min_row][column[min_row]]) {
          min_row = i;
        }      
      }
      // count of elements equal to minimum in current last column
      int eq_count = 0;
      for (int i = 0; i < M; i++) {
        if (matrix[i][column[i]] > matrix[min_row][column[min_row]]) {
          // decrease when current element larger than minimum
          if (column[i] == 0) return -1;          
          column[i]--;
        } else {
          eq_count++;
        }
      }
      if (eq_count == M) {
        return matrix[min_row][column[min_row]];
      }
    }
    return -1;
  }
}

