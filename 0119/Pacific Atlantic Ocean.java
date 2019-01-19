public List<int[]> pacificAtlantic(int[][] matrix) {
    List<int[]> res = new ArrayList<>();
    if (matrix == null || matrix.length == 0) return res;
    int M = matrix.length;
    int N = matrix[0].length;
    boolean[][] pacific = new boolean[M][N];
    boolean[][] atlantic = new boolean[M][N];
    for (int i = 0; i < M; i++) {
      dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
      dfs(matrix, atlantic, Integer.MIN_VALUE, i, N - 1);
    }
    for (int i = 0; i < N; i++) {
      dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
      dfs(matrix, atlantic, Integer.MIN_VALUE, M - 1, i);
    }
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          res.add(new int[] {i, j});
        }
      }
    }
    return res;
  }
  // Little trick: final variable of DIRECTIONs
  final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  
  private void dfs(int[][] matrix, boolean[][] visited, int height, int row, int col) {
    if (row < 0 || row >= matrix.length || col< 0 || col >= matrix[0].length || visited[row][col] || matrix[row][col] < height) {
      return;
    }
    visited[row][col] = true;
    for (int[] dir : DIRS) {
      dfs(matrix, visited, matrix[row][col], row + dir[0], col + dir[1]);
    }
  }
