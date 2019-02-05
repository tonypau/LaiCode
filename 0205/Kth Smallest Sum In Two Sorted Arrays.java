public class Solution {
  static class Pair {
    int i;
    int j;
    int val;
    Pair(int i, int j, int val) {
      this.i = i;
      this.j = j;
      this.val = val;
    }
  }
  
  public int kthSum(int[] A, int[] B, int k) {
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
      @Override
      public int compare(Pair p1, Pair p2) {
        if (p1.val == p2.val) return 0;
        return p1.val < p2.val ? -1 : 1;
      }
    });
    minHeap.offer(new Pair(0, 0, A[0] + B[0]));
    boolean[][] visited = new boolean[A.length][B.length];
    visited[0][0] = true;
    for (int i = 0; i < k - 1; i++) {
      Pair cur = minHeap.poll();
      if (cur.i + 1 < A.length && !visited[cur.i + 1][cur.j]) {
        minHeap.offer(new Pair(cur.i + 1, cur.j, A[cur.i + 1] + B[cur.j]));
        visited[cur.i + 1][cur.j] = true;
      }
      if (cur.j + 1 < B.length && !visited[cur.i][cur.j + 1]) {
        minHeap.offer(new Pair(cur.i, cur.j + 1, A[cur.i] + B[cur.j + 1]));
        visited[cur.i][cur.j + 1] = true;
      }
    }
    return minHeap.peek().val;
  }
}
