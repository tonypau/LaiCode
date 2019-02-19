// Chair马甲题
// 从1出发，找跟其他0的距离
// O(nlogn). n为1的个数
// O(n^2) cost array
public class Solution {
  public int minTotalDistance(int[][] grid) {
    int M = grid.length; 
    if (M == 0) return 0;
    int N = grid[0].length;
    if (N == 0) return 0;
    int[][] cost = new int[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (grid[i][j] == 1) {
          addCost(grid, cost, i, j, M, N);
        }
      }
    }
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (cost[i][j] < res) {
          res = cost[i][j];
        }
      }
    }
    return res;
  }
  
  private void addCost(int[][] grid, int[][] cost, int i, int j, int M, int N) {
    Queue<Pair> queue = new LinkedList<>();
    boolean[][] visited = new boolean[M][N];
    queue.offer(new Pair(i, j));
    visited[i][j] = true;
    int pathCost = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int index = 0; index < size; index++) {
        Pair cur = queue.poll();
        for (Pair nei : getNeis(cur, grid, M, N)) {
          if (!visited[nei.x][nei.y]) {
            cost[nei.x][nei.y] += pathCost;
            visited[nei.x][nei.y] = true;
            queue.offer(nei);
          }
        }
      }
      pathCost++;
    }
  }
  
  private List<Pair> getNeis(Pair cur, int[][] grid, int M, int N) {
    List<Pair> res = new ArrayList<>();
    if (cur.x + 1 < M) res.add(new Pair(cur.x + 1, cur.y));
    if (cur.y + 1 < N) res.add(new Pair(cur.x, cur.y + 1));
    if (cur.x - 1 >= 0) res.add(new Pair(cur.x - 1, cur.y));
    if (cur.y - 1 >= 0) res.add(new Pair(cur.x, cur.y - 1));
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
