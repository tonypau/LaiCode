/**
 * public class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */
public class Solution {
  public boolean isBipartite(List<GraphNode> graph) {
    Map<GraphNode, Integer> visited = new HashMap<>();
    for (GraphNode node : graph) {
      if (!BFS(visited, node)) {
        return false;
      }
    }
    return true;
  }
  
  private boolean BFS(Map<GraphNode, Integer> visited, GraphNode node) {
    if (visited.containsKey(node)) return true;
    Queue<GraphNode> queue = new LinkedList<>();
    visited.put(node, 0);
    queue.offer(node);
    while (!queue.isEmpty()) {
      GraphNode cur = queue.poll();
      int curColor = visited.get(cur);
      int neiColor = curColor == 0 ? 1 : 0;
      for (GraphNode nei : cur.neighbors) {
        if (visited.containsKey(nei)) {
          if (visited.get(nei) != neiColor) {
            return false;
          } 
        } else {
          visited.put(nei, neiColor);
          queue.offer(nei);
        }
      }
    }
    return true;
  }
}


