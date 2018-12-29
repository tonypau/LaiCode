/*
  dp in the first sight, but using histogram.
  think about looking at the matrix in the bottom-up way as a histogram.
  add up every row from the row above, then find the max area in the current row using histogram method.
  
  For example:
    0 1 1 0
    1 1 1 1
    1 1 1 1
    1 1 0 0
  
    row1: 0 1 1 0    max: 2
    row2: 1 2 2 1    max: 4
    row3: 2 3 3 2    max: 8
    row4: 3 4 0 0    max: 6, Math.max(6, 8) = 8
*/

public class Solution {
  public int largest(int[][] matrix) {
    int res = 0;
    int M = matrix.length;
    int N = matrix[0].length;
    
    // to avoid ArrayOutOfBound Exception, using histogram with first row outside the loop.
    res = Math.max(histogram(matrix[0]), res);
    for (int i = 1; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (matrix[i][j] == 1) {
          matrix[i][j] += matrix[i - 1][j];
        }
      }
      res = Math.max(histogram(matrix[i]), res);
    }
    return res;
  }
  
  private int histogram(int[] row) {
    Deque<Integer> stack = new LinkedList<>();
    int max = 0;
    
    // NOTICE!!! i can be row.length, because i is exclusive in this method.
    for (int i = 0; i <= row.length; i++) {
      int cur = i == row.length ? 0 : row[i];
      while (!stack.isEmpty() && row[stack.peekLast()] >= cur) {
        int height = row[stack.pollLast()];
        int left = stack.isEmpty() ? 0 : stack.peekLast() + 1;
        max = Math.max(max, height * (i - left));
      }
      stack.offerLast(i);
    }
    
    return max;
  }
}

