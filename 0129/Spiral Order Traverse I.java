public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    int N = matrix.length;
    int offset = (N + 1) / 2;
    for (int i = 0; i < offset; i++) {
     // NOTICE corner case
      if (i == N - 1 - i) {
        res.add(matrix[i][N - 1 - i]);
      }
      for (int j = i; j < N - 1 - i; j++) {
        res.add(matrix[i][j]);
      }
      for (int j = i; j < N - 1 - i; j++) {
        res.add(matrix[j][N - 1 - i]);
      }
      for (int j = N - 1 - i; j > i; j--) {
        res.add(matrix[N - 1 - i][j]);
      }
      for (int j = N - 1 - i; j > i; j--) {
        res.add(matrix[j][i]);
      }
    }
    return res;
  }
}

