/*
* class GraphNode {
*   public int key;
*   public List<GraphNode> neighbors;
*   public GraphNode(int key) {
*     this.key = key;
*     this.neighbors = new ArrayList<GraphNode>();
*   }
* }
*/
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    List<GraphNode> res = new ArrayList<>();
    if (graph == null) return res;
    Map<GraphNode, GraphNode> map = new HashMap<>();
    Queue<GraphNode> queue = new LinkedList<>();
    for (GraphNode node : graph) {
      queue.offer(node);
      while (!queue.isEmpty()) {
        GraphNode cur = queue.poll();
        if (!map.containsKey(cur)) {
          map.put(cur, new GraphNode(cur.key));
        }
        for (GraphNode nei : cur.neighbors) {
          if (!map.containsKey(nei)) {
            map.put(nei, new GraphNode(nei.key));
          }
          map.get(cur).neighbors.add(map.get(nei));
        }
        res.add(map.get(cur));
      }
    }
    return res;
  }
}
