// perform DFS on each element in matrix
// cache[i][j] stores the longest ascending path starting from [i][j]

// tc: O(n^2 * 4^n)
//      n^2 times dfs, for each dfs, n levels and 4 branches in each level
// sc: O(n^2)
//      cache space
public class Solution {
  int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
  public int longest(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    int M = matrix.length;
    int N = matrix[0].length;
    int[][] cache = new int[M][N];
    int max = 1;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        int len = dfs(matrix, i, j, M, N, cache);
        max = Math.max(max, len);
      }
    }
    return max;
  }
  
  private int dfs(int[][] matrix, int i, int j, int M, int N, int[][] cache) {
    if (cache[i][j] != 0) return cache[i][j];
    int max = 1;
    for (int[] dir : dirs) {
      int x = i + dir[0];
      int y = j + dir[1];
      if (x < 0 || x >= M || y < 0 || y >= N || matrix[x][y] <= matrix[i][j]) continue;
      int len = 1 + dfs(matrix, x, y, M, N, cache);
      max = Math.max(max, len);
    }
    cache[i][j] = max;
    return max;
  }
}
