// Mathod1: BFS
public class Solution {
  private static final int[] row = {-1,1,0,0};
  private static final int[] col = {0,0,-1,1};
  
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }  
    int M = grid.length; 
    int N = grid[0].length;
    boolean[][] visited = new boolean[M][N];
    int count = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          count++;
          BFS(grid, visited, i, j);
        }
      }
    }
    return count;
  }
  
  private void BFS(char[][] grid, boolean[][] visited, int i, int j) {
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(i, j));
    while (!queue.isEmpty()) {
      Pair cur = queue.poll();
      for (Pair nei : getNeis(grid, cur)) {
        if (!visited[nei.x][nei.y]) {
          visited[nei.x][nei.y] = true;
          queue.offer(nei);
        }
      }
    }
  }
  
  private List<Pair> getNeis(char[][] grid, Pair cur) {
    List<Pair> res = new ArrayList<>();
    for (int k = 0; k < 4; k++) {
      if (cur.x + row[k] >= 0 && cur.x + row[k] < grid.length 
          && cur.y + col[k] >= 0 && cur.y + col[k] < grid[0].length 
          && grid[cur.x + row[k]][cur.y + col[k]] == '1') {
        res.add(new Pair(cur.x + row[k], cur.y + col[k]));
      }
    }
    return res;
  }
  
  static class Pair {
    int x;
    int y;
    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}

// Method2: DFS
public class Solution {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
    int M = grid.length;
    int N = grid[0].length;
    int count = 0;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (grid[i][j] == '1') {
          count++;
          merge(grid, i, j, M, N);
        }
      }
    }
    return count;
  }
  
  private void merge(char[][] grid, int i, int j, int M, int N) {
    if (i < 0 || i >= M || j < 0 || j >= N || grid[i][j] != '1') {
      return;
    }
    grid[i][j] = 'X';
    merge(grid, i + 1, j, M, N);
    merge(grid, i, j + 1, M, N);
    merge(grid, i - 1, j, M, N);
    merge(grid, i, j - 1, M, N);
  }
}

