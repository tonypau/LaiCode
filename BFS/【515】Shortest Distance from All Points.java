public class Solution {
  public int shortestDistance(int[][] grid) {
    int M = grid.length;
    if (M == 0) return -1;
    int N = grid[0].length;
    if (N == 0) return -1;
    int[][] cost = new int[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (grid[i][j] == 1) {
          if (!addCost(grid, cost, i, j, M, N)) {
            return -1;
          }
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (grid[i][j] == 0) min = Math.min(cost[i][j], min);
      }
    }
    return min == Integer.MAX_VALUE ? -1 : min;
  }
  
  private boolean addCost(int[][] grid, int[][] cost, int i, int j, int M, int N) {
    Queue<Pair> queue = new LinkedList<>();
    boolean[][] visited = new boolean[M][N];
    queue.offer(new Pair(i, j));
    visited[i][j] = true;
    int pathCost = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int k = 0; k < size; k++) {
        Pair cur = queue.poll();
        for (Pair nei : getNeis(cur, grid, M, N)) {
          if (!visited[nei.x][nei.y]) {
            queue.offer(new Pair(nei.x, nei.y));
            visited[nei.x][nei.y] = true;
            cost[nei.x][nei.y] += pathCost;
          }
        }
      }
      pathCost++;
    }
    for (int x = 0; x < M; x++) {
      for (int y = 0; y < N; y++) {
        if (grid[x][y] == 0 && !visited[x][y]) {
          return false;
        }
      }
    }
    return true;
  }
  
  private List<Pair> getNeis(Pair cur, int[][] grid, int M, int N) {
    List<Pair> res = new ArrayList<>();
    if (cur.x + 1 < M && grid[cur.x + 1][cur.y] == 0) {
      res.add(new Pair(cur.x + 1, cur.y));
    }
    if (cur.x - 1 >= 0 && grid[cur.x - 1][cur.y] == 0) {
      res.add(new Pair(cur.x - 1, cur.y));
    }
    if (cur.y + 1 < N && grid[cur.x][cur.y + 1] == 0) {
      res.add(new Pair(cur.x, cur.y + 1));
    }
    if (cur.y - 1 >= 0 && grid[cur.x][cur.y - 1] == 0) {
      res.add(new Pair(cur.x, cur.y - 1));
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
