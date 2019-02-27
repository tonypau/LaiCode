// we need to keep recording the min height within neighbors of every node. so we need to maintain a minHeap
// tc: O(n^2 * logn^2)
// sc: O(n^2)
public class Solution {
  static class Pair {
    int x;
    int y;
    int height;
    
    Pair(int x, int y, int height) {
      this.x = x;
      this.y = y;
      this.height = height;
    }
  }
  
  public int maxTrapped(int[][] matrix) {
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>(){
      @Override
      public int compare(Pair p1, Pair p2) {
        if (p1.height == p2.height) return 0;
        return p1.height < p2.height ? -1 : 1;
      }
    });
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    int res = 0;
    insertBorder(matrix, minHeap, visited);  
    while (!minHeap.isEmpty()) {
      Pair cur = minHeap.poll();
      res += cur.height - matrix[cur.x][cur.y];
      for (Pair nei : getNeis(matrix, cur)) {
        if (!visited[nei.x][nei.y]) {
          if (nei.height < cur.height) {
            nei.height = cur.height;
          }
          visited[nei.x][nei.y] = true;
          minHeap.offer(nei);
        }
      }
    }
    return res;
  }
  
  private void insertBorder(int[][] matrix, PriorityQueue<Pair> minHeap, boolean[][] visited) {
    for (int i = 0; i < matrix[0].length - 1; i++) {
      minHeap.offer(new Pair(0, i, matrix[0][i]));
      visited[0][i] = true;
    }
    for (int i = 0; i < matrix.length - 1; i++) {
      minHeap.offer(new Pair(i, matrix[0].length - 1, matrix[i][matrix[0].length - 1]));
      visited[i][matrix[0].length - 1] = true;
    }
    for (int i = matrix[0].length - 1; i > 0; i--) {
      minHeap.offer(new Pair(matrix.length - 1, i, matrix[matrix.length - 1][i]));
      visited[matrix.length - 1][i] = true;
    }
    for (int i = matrix.length - 1; i > 0; i--) {
      minHeap.offer(new Pair(i, 0, matrix[i][0]));
      visited[i][0] = true;
    }
  }
  
  private List<Pair> getNeis(int[][] matrix, Pair cur) {
    List<Pair> res = new ArrayList<>();
    int M = matrix.length;
    int N = matrix[0].length;
    int x = cur.x;
    int y = cur.y;
    if (x + 1 < M) res.add(new Pair(x + 1, y, matrix[x + 1][y]));
    if (x - 1 >= 0) res.add(new Pair(x - 1, y, matrix[x - 1][y]));
    if (y + 1 < N) res.add(new Pair(x, y + 1, matrix[x][y + 1]));
    if (y - 1 >= 0) res.add(new Pair(x, y - 1, matrix[x][y - 1]));
    return res;
  }
}

