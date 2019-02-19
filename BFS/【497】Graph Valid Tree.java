// 找到判错条件：一个node不能被poll出两遍，也就是不能倍被塞进queue里两次，也就是不能有两个parent

public class Solution {
  public boolean validTree(int n, int[][] edges) {
    Map<Integer, List<Integer>> map = getMap(edges, n);
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(0);
    while (!queue.isEmpty()) {
      Integer cur = queue.poll();
      if (visited[cur]) {
        return false;
      } else {
        visited[cur] = true;
      }
      for (Integer nei : map.get(cur)) {
        if (!visited[nei]) {
          queue.offer(nei);
        }
      }
    }
    for (boolean b : visited) {
      if (!b) return false;
    }
    return true;
  }

  private Map<Integer, List<Integer>> getMap(int[][] edges, int n) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      List<Integer> list = new ArrayList<>();
      map.put(i, list);
    }
    for (int[] arr : edges) {
      map.get(arr[0]).add(arr[1]);
      map.get(arr[1]).add(arr[0]);
    }
    return map;
  }
}
