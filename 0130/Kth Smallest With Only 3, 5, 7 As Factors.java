public class Solution {
  public long kth(int k) {
    PriorityQueue<Long> pq = new PriorityQueue<>();
    Set<Long> visited = new HashSet<>();
    visited.add(3 * 5 * 7L);
    pq.offer(3 * 5 * 7L);
    while (k > 1) {
      Long num = pq.poll();
      if (visited.add(3 * num)) pq.offer(3 * num);
      if (visited.add(5 * num)) pq.offer(5 * num);
      if (visited.add(7 * num)) pq.offer(7 * num);
      k--;
    }
    return pq.peek();
  }
}
