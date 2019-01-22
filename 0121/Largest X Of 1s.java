public class Solution {
  public int largest(int[][] matrix) {
    int M = matrix.length;
    if (M == 0) return 0;
    int N = matrix[0].length;
    if (N == 0) return 0;
    int[][] leftUp = new int[M][N];
    int[][] rightUp = new int[M][N];
    int[][] leftBottom = new int[M][N];
    int[][] rightBottom = new int[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (matrix[i][j] == 1) {
          leftUp[i][j] = getNumber(leftUp, i - 1, j - 1, M, N) + 1;
          rightUp[i][j] = getNumber(rightUp, i - 1, j + 1, M, N) + 1;
        }
      }
    }
    for (int i = M - 1; i >= 0; i--) {
      for (int j = N - 1; j >= 0; j--) {
        if (matrix[i][j] == 1) {
          leftBottom[i][j] = getNumber(leftBottom, i + 1, j - 1, M, N) + 1;
          rightBottom[i][j] = getNumber(rightBottom, i + 1, j + 1, M, N) + 1;
        }
      }
    }
    merge(leftUp, rightUp, M, N);
    merge(leftBottom, rightBottom, M, N);
    return merge(leftUp, leftBottom, M, N);
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
  
  private int getNumber(int[][] m, int row, int col, int M, int N) {
    if (row >= M || col >= N || row < 0 || col < 0) {
      return 0;
    }
    return m[row][col];
  }
}

