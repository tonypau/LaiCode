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

// Method 1: DFS
// TC: O(n)
// SC: O(n)
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    if (graph == null) return null;
    Map<GraphNode, GraphNode> map = new HashMap<>();
    List<GraphNode> res = new ArrayList<>();
    for (GraphNode node : graph) {
      res.add(helper(node, map));
    }
    return res;
  }
  
  // return value is the clone of input node
  private GraphNode helper(GraphNode node, Map<GraphNode, GraphNode> map) {
    if (node == null) {
      return null;
    }
    if (map.containsKey(node)) {
      return map.get(node);
    }
    GraphNode copyNode = new GraphNode(node.key);
    map.put(node, copyNode);
    // for each neighbor of every node, we clone it and add into the neighbors of its clone node
    for (GraphNode nei : node.neighbors) {
      copyNode.neighbors.add(helper(nei, map));
    }
    return copyNode;
  }
}

// Method 2: BFS
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
