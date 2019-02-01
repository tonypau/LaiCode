// t: O(n^2) traverse once 从边缘向中心收拢，类似一维的积水问题，从两边向中间收拢。木桶最短原理，只要记录一个目前最低值。
// s: O(n^2) visited matrix
public class Solution {
  static class Pair {
    int x;
    int y;
    int val;
    Pair(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }
  }
  
  public int maxTrapped(int[][] matrix) {
    int M = matrix.length;
    int N = matrix[0].length;
    // BFS-2, uses MIN_HEAP
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>(){
      @Override
      public int compare(Pair p1, Pair p2) {
        if (p1.val == p2.val) return 0;
        return p1.val < p2.val ? -1 : 1;
      }
    });
    boolean[][] visited = new boolean[M][N];
    insertBorder(visited, matrix, M, N, minHeap);
    int res = 0;
    while (!minHeap.isEmpty()) {
      Pair cur = minHeap.poll();
      res += cur.val - matrix[cur.x][cur.y];
      for (Pair nei : getNeis(cur, matrix, M, N)) {
        if (!visited[nei.x][nei.y]) {
          if (nei.val < cur.val) {
            nei.val = cur.val;
          }
          minHeap.offer(nei);
          visited[nei.x][nei.y] = true;
        }
      }
    }
    return res;
  }
  
  private void insertBorder(boolean[][] visited, int[][] matrix, int M, int N, PriorityQueue<Pair> minHeap) {
    for (int i = 0; i < N - 1; i++) {
      minHeap.offer(new Pair(0, i, matrix[0][i]));
      visited[0][i] = true;
    }
    for (int i = 0; i < M - 1; i++) {
      minHeap.offer(new Pair(i, N - 1, matrix[i][N - 1]));
      visited[i][N - 1] = true;
    }
    for (int i = N - 1; i > 0; i--) {
      minHeap.offer(new Pair(M - 1, i, matrix[M - 1][i]));
      visited[M - 1][i] = true;
    }
    for (int i = M - 1; i > 0; i--) {
      minHeap.offer(new Pair(i, 0, matrix[i][0]));
      visited[i][0] = true;
    }
  }
  
  private List<Pair> getNeis(Pair cur, int[][] matrix, int M, int N) {
    List<Pair> res = new ArrayList<>();
    int x = cur.x;
    int y = cur.y;
    if (x + 1 < M) res.add(new Pair(x + 1, y, matrix[x + 1][y]));
    if (x - 1 >= 0) res.add(new Pair(x - 1, y, matrix[x - 1][y]));
    if (y + 1 < N) res.add(new Pair(x, y + 1, matrix[x][y + 1]));
    if (y - 1 >= 0) res.add(new Pair(x, y - 1, matrix[x][y - 1]));
    return res;
  }
}
