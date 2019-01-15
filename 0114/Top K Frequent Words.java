public class Solution {
  public String[] topKFrequent(String[] combo, int k) {
    if (combo.length == 0) return new String[0];
    Map<String, Integer> map = new HashMap<>();
    for (String s : combo) {
      Integer num = map.get(s);
      if (num == null) map.put(s, 1);
      else map.put(s, num + 1);
    }
    PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
        if (m1.getValue() == m2.getValue()) {
          return 0;
        }
        return m1.getValue() < m2.getValue() ? -1 : 1;
      }
    });
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (minHeap.size() < k) {
        minHeap.offer(entry);
      } else if (minHeap.peek().getValue() < entry.getValue()) {
        minHeap.poll();
        minHeap.offer(entry);
      }
    }
    String[] res = new String[minHeap.size()];
    for (int i = minHeap.size() - 1; i >= 0; i--) {
      res[i] = minHeap.poll().getKey();
    }
    return res;
  }
}

