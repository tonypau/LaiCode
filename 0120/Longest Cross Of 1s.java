public class Solution {
  public int largest(int[][] matrix) {
    int M = matrix.length;
    if (M == 0) return 0;
    int N = matrix[0].length;
    if (N == 0) return 0;
    int[][] leftAndDown = getLeftAndDown(matrix, M, N);
    int[][] rightAndUp = getRightAndUp(matrix, M, N);
    return merge(leftAndDown, rightAndUp, M, N);
  }
  
  private int[][] getLeftAndDown(int[][] matrix, int M, int N) {
    int[][] left = new int[M][N];
    int[][] down = new int[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (matrix[i][j] == 1) {
          if (i == 0 && j == 0) {
            left[i][j] = 1;
            down[i][j] = 1;
          } else if (i == 0) {
            left[i][j] = left[i][j - 1] + 1;
            down[i][j] = 1;
          } else if (j == 0) {
            left[i][j] = 1;
            down[i][j] = down[i - 1][j] + 1;
          } else {
            left[i][j] = left[i][j - 1] + 1;
            down[i][j] = down[i - 1][j] + 1;
          }
        }
      }
    }
    merge(left, down, M, N);
    return left;
  }
  
  private int[][] getRightAndUp(int[][] matrix, int M, int N) {
    int[][] right = new int[M][N];
    int[][] up = new int[M][N];
    for (int i = M - 1; i >= 0; i--) {
      for (int j = N - 1; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          if (i == M - 1 && j == N - 1) {
            right[i][j] = 1;
            up[i][j] = 1;
          } else if (i == M - 1) {
            right[i][j] = right[i][j + 1] + 1;
            up[i][j] = 1;
          } else if (j == N - 1) {
            right[i][j] = 1;
            up[i][j] = up[i + 1][j] + 1;
          } else {
            right[i][j] = right[i][j + 1] + 1;
            up[i][j] = up[i + 1][j] + 1;
          }
        }
      }
    }
    merge(right, up, M, N);
    return right;
  }
  
  private int merge(int[][] one, int[][] two, int M, int N) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        one[i][j] = Math.min(one[i][j], two[i][j]);
        max = Math.max(max, one[i][j]);
      }
    }
    return max;
  }
}

