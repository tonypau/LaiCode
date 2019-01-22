public class Solution {
  public int largest(int[][] matrix) {
    int M = matrix.length;
    int N = matrix[0].length;
    for (int i = 1; i < M; i++) {
      for (int j = 0; j < N; j++) {
        matrix[i][j] += matrix[i - 1][j];
      }
    }
    int[] helper = new int[N];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < M; i++) {
      for (int j = M - 1; j >= i; j--) {
        int cur = 0;
        for (int k = 0; k < N; k++) {
          if (i == 0) {
            helper[k] = matrix[j][k];
          } else {
            helper[k] = matrix[j][k] - matrix[i - 1][k];
          }
          cur += helper[k];
          max = Math.max(max, cur);
          if (cur < 0) {
            cur = 0;
          }
        }
      }
    }
    return max;
  }
}

/*
{-1,-2,-3},
{-4,-3,-2},
{-3,0,-1}
*/

/*
{-1,-2,-3},
{-5,-5,-5},
{-8,-5,-6}

*/






