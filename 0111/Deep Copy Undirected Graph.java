/*
[132]
Make a deep copy of an undirected graph, there could be cycles in the original graph.

Assumptions

The given graph is not null
*/

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

// these two are dfs, also can be solved with bfs

// Sol1:
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    if (graph == null) return null;
    List<GraphNode> list = new ArrayList<>();
    Map<GraphNode, GraphNode> map = new HashMap<>();
    for (GraphNode node : graph) {
      list.add(cloneGraph(node, map));
    }
    return list;
  }
  
  private GraphNode cloneGraph(GraphNode node, Map<GraphNode, GraphNode> map) {
    if (node == null) return null;
    if (map.containsKey(node)) {
      return map.get(node);
    }
    GraphNode copyNode = new GraphNode(node.key);
    map.put(node, copyNode);
    for (GraphNode nei : node.neighbors) {
      copyNode.neighbors.add(cloneGraph(nei, map));
    }
    return copyNode;
  }
}

// Sol2:
public class Solution {
  public List<GraphNode> copy(List<GraphNode> graph) {
    // Write your solution here
    if (graph == null) return null;
    Map<GraphNode, GraphNode> map = new HashMap<>();
    for (GraphNode node : graph) {
      if (!map.containsKey(node)) {
        map.put(node, new GraphNode(node.key));
        DFS(node, map);      
      }
    }
    return new ArrayList<GraphNode>(map.values());
  }
  
  private void DFS(GraphNode node, Map<GraphNode, GraphNode> map) {
    GraphNode copyNode = map.get(node);
    for (GraphNode nei : node.neighbors) {
      if (!map.containsKey(nei)) {
        map.put(nei, new GraphNode(nei.key));
        DFS(nei, map);
      }
      copyNode.neighbors.add(map.get(nei));
    }
  }
}