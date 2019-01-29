public class Solution {
  public void rotate(int[][] matrix) {
    rotateDiagonal(matrix);
    rotateVertical(matrix);
  }
  
  private void rotateDiagonal(int[][] matrix) {
    int N = matrix.length;
    for (int i = 0; i < N - 1; i++) {
      for (int j = 0; j + i < N - 1; j++) {
        swap(matrix, i, j, N - 1 - j, N - 1 - i);
      }
    }
  }
  
  private void rotateVertical(int[][] matrix) {
    int N = matrix.length;
    for (int i = 0; i < N / 2; i++) {
      for (int j = 0; j < N; j++) {
        swap(matrix, i, j, N - 1 - i, j);
      }
    }
  }
  
  private void swap(int[][] nums, int i, int j, int ii, int jj) {
    int tmp = nums[i][j];
    nums[i][j] = nums[ii][jj];
    nums[ii][jj] = tmp;
  }  
}


