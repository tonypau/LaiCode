public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    int M = matrix.length;
    int N = matrix[0].length;    
    int offset = (Math.min(M, N) + 1) / 2;
    for (int i = 0; i < offset; i++) {
      if (i == M - 1 - i && i == N - 1 - i) {
        res.add(matrix[i][i]);
      } else if (i == M - 1 - i || i == N - 1 - i) {
        if (i == M - 1 - i) {
          for (int j = i; j < N - i; j++) {
            res.add(matrix[i][j]);          
          }
        }
        if (i == N - 1 - i) {
          for (int j = i; j < M - i; j++) {
            res.add(matrix[j][i]);          
          }
        }
      } else {
        for (int j = i; j < N - 1 - i; j++) {
          res.add(matrix[i][j]);
        }
        for (int j = i; j < M - 1 - i; j++) {
          res.add(matrix[j][N - 1 - i]);
        }
        for (int j = N - 1 - i; j > i; j--) {
          res.add(matrix[M - 1 - i][j]);
        }
        for (int j = M - 1 - i; j > i; j--) {
          res.add(matrix[j][i]);
        }
      }
    }
    return res;
  }
}

