public class Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (edges == null || edges.length == 0 || edges[0].length == 0) {
      return Arrays.asList(0);    
    }
    Map<Integer, List<Integer>> map = getMap(edges, n);
    int[] minHeight = new int[] {Integer.MAX_VALUE};
    Map<Integer, List<Integer>> height = new HashMap<>();
    for (int i = 0; i < n; i++) {
      BFS(map, height, i, minHeight, n);
    }
    return height.get(minHeight[0]);
  }
  
  private void BFS(Map<Integer, List<Integer>> map, Map<Integer, List<Integer>> height, int i, int[] minHeight, int n) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(i);
    boolean[] visited = new boolean[n];
    int h = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int k = 0; k < size; k++) {
        Integer cur = queue.poll();
        visited[cur] = true;
        for (Integer nei : map.get(cur)) {
          if (!visited[nei]) {
            queue.offer(nei);
            visited[nei] = true;
          }
        }
      }
      if (!queue.isEmpty()) h++;
    }
    minHeight[0] = Math.min(minHeight[0], h);
    if (!height.containsKey(h)) height.put(h, new ArrayList<Integer>());
    height.get(h).add(i);
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

