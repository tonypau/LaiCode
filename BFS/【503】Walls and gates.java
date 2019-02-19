// O(nlogn)
// BFS-2 边长不变的类型
public class Solution {
  public int[][] wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0) return rooms;
    int M = rooms.length;
    int N = rooms[0].length;
    int[][] res = new int[M][N];
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (rooms[i][j] == 0) {
          addCost(rooms, i, j, M, N);
        }
      }
    }
    return rooms;
  }
  
  private void addCost(int[][] rooms, int i, int j, int M, int N) {
    boolean[][] visited = new boolean[M][N];
    int[][] cost = new int[M][N];
    Queue<Pair> queue = new LinkedList<>();
    queue.offer(new Pair(i, j));
    visited[i][j] = true;
    int pathCost = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int index = 0; index < size; index++) {
        Pair cur = queue.poll();
        for (Pair nei : getNeis(cur, rooms, M, N)) {
          if (!visited[nei.x][nei.y]) {
            cost[nei.x][nei.y] += pathCost;
            rooms[nei.x][nei.y] = Math.min(rooms[nei.x][nei.y], cost[nei.x][nei.y]);
            queue.offer(nei);
            visited[nei.x][nei.y] = true;          
          }
        }
      }
      pathCost++;
    }
  }
  
  private List<Pair> getNeis(Pair cur, int[][] rooms, int M, int N) {
    List<Pair> res = new ArrayList<>();
    if (cur.x + 1 < M && rooms[cur.x + 1][cur.y] != -1) {
      res.add(new Pair(cur.x + 1, cur.y));
    }
    if (cur.x - 1 >= 0 && rooms[cur.x - 1][cur.y] != -1) {
      res.add(new Pair(cur.x - 1, cur.y));
    }
    if (cur.y + 1 < N && rooms[cur.x][cur.y + 1] != -1) {
      res.add(new Pair(cur.x, cur.y + 1));
    }
    if (cur.y - 1 >= 0 && rooms[cur.x][cur.y - 1] != -1) {
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

