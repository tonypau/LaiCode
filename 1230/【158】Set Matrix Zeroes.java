/*
  the unique idea from this problem is:
    when solving in-place problems, we can consider taking advantage of the exist data structure.
  we use the first row and first col to record whether the row or col contains 0.
  
  O(n^2)
*/

public class Solution {
  public void setZero(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }
    int m = matrix.length - 1;
    int n = matrix[0].length - 1;
    // two boolean record if first row and first col contain zeroes.
    // then we can take advantage of the space of the first row and first col.
    boolean firstRowZero = false;
    boolean firstColZero = false;
    
    // check if first col has 0
    for (int i = 0; i <= m; i++) {
      if (matrix[i][0] == 0) {
        firstColZero = true;
        break;
      }
    }
    // check if first row has 0
    for (int i = 0; i <= n; i++) {
      if (matrix[0][i] == 0) {
        firstRowZero = true;
        break;
      }
    }
    // mark 0 on first row and col
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }
    
    // update elements excluding the first row and first col
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;          
        }
      }
    }
    
    // update first row and col.
    if (firstRowZero) {
      for (int i = 0; i <= n; i++) {
        matrix[0][i] = 0;
      }
    }
    if (firstColZero) {
      for (int i = 0; i <= m; i++) {
        matrix[i][0] = 0;
      }
    }
  }
}

