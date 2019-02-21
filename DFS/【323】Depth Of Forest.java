public class Solution {
  public int depth(int[] forest) {
    if (forest == null || forest.length == 0) return 0;
    int[] max = new int[1];
    Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < forest.length; i++) {
      if (!dfs(forest, visited, i, 1, max)) {
        return -1;
      } 
    }
    return max[0];
  }
  
  private boolean dfs(int[] forest, Set<Integer> visited, int node, int curHeight, int[] max) {
    if (visited.contains(node)) {
      return false;
    } else if (forest[node] == -1) {
      max[0] = Math.max(max[0], curHeight);
      return true;
    }
    visited.add(node);
    if (!dfs(forest, visited, forest[node], curHeight + 1, max)) return false;
    visited.remove(node);
    return true;
  }
}
