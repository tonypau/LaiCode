public class Solution {
  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
    PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>() {
      @Override
      public int compare(List<Integer> list1, List<Integer> list2) {
        long distance1 = getDis(list1, a, b, c);
        long distance2 = getDis(list2, a, b, c);
        if (distance1 == distance2) {
          return 0;
        }
        return distance1 < distance2 ? -1 : 1;
      }
    });
    Set<List<Integer>> visited = new HashSet<>();
    List<Integer> list = Arrays.asList(0,0,0);
    minHeap.offer(list);
    visited.add(list);
    while (k > 1) {
      List<Integer> cur = minHeap.poll();
      List<Integer> n = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
      if (n.get(0) < a.length && visited.add(n)) {
        minHeap.offer(n);  
      }
      n = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
      if (n.get(1) < b.length && visited.add(n)) {
        minHeap.offer(n);  
      }
      n = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
      if (n.get(2) < c.length && visited.add(n)) {
        minHeap.offer(n);  
      }
      k--;
    }
    return Arrays.asList(a[minHeap.peek().get(0)], b[minHeap.peek().get(1)], c[minHeap.peek().get(2)]);
  }
  
  private long getDis(List<Integer> list, int[] a, int[] b, int[] c) {
    long dis = 0;
    dis += a[list.get(0)] * a[list.get(0)] + b[list.get(1)] * b[list.get(1)] + c[list.get(2)] * c[list.get(2)];
    return dis;
  }
}

