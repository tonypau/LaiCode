public class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    int M = matrix.length;
    int N = matrix[0].length;
    PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
      @Override
      public int compare(Cell c1, Cell c2) {
        if (c1.val == c2.val) {
          return 0;
        }
        return c1.val < c2.val ? -1 : 1;
      }
    });  
    boolean[][] visited = new boolean[M][N];
    minHeap.offer(new Cell(matrix[0][0], 0, 0));
    for (int i = 0; i < k - 1; i++) {
      Cell cur = minHeap.poll();
      if (cur.row + 1 < M && !visited[cur.row + 1][cur.col]) {
        minHeap.offer(new Cell(matrix[cur.row + 1][cur.col], cur.row + 1, cur.col));
        visited[cur.row + 1][cur.col] = true;
      }
      if (cur.col + 1 < N && !visited[cur.row][cur.col + 1]) {
        minHeap.offer(new Cell(matrix[cur.row][cur.col + 1], cur.row, cur.col + 1));
        visited[cur.row][cur.col + 1] = true;
      }
    }
    return minHeap.peek().val;
  }
  
  static class Cell {
    int val;
    int row;
    int col;
    Cell(int val, int row, int col) {
      this.val = val;
      this.row = row;
      this.col = col;
    }
  }
}

