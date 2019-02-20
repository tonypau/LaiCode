public class Solution {
  public int countComponents(int n, int[][] edges) {
    Map<Integer, List<Integer>> map = getMap(edges, n);
    int count = 0;
    int M = edges.length;
    int N = edges[0].length;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        count++;
        BFS(visited, map, i);
      }
    }
    return count;
  }
  
  private void BFS(boolean[] visited, Map<Integer, List<Integer>> map, int i) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(i);
    while (!queue.isEmpty()) {
      Integer cur = queue.poll();
      visited[cur] = true;
      for (Integer nei : map.get(cur)) {
        if (!visited[nei]) {
          queue.offer(nei);
        }
      }
    }
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

