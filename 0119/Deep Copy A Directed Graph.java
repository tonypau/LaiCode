private List<GraphNode> copy(List<GraphNode> graph) {
    if (graph == null) return null;
    List<GraphNode> res = new ArrayList<>();
    Map<GraphNode, GraphNode> map = new HashMap<>();
    for (GraphNode node : graph) {
      if (!map.containsKey(node)) {
        GraphNode newNode = new GraphNode(node.key);
        map.put(node, newNode);
        dfs(node, map);
      }
      res.add(map.get(node));
    }
    return res;
  } 
  
  private void dfs(GraphNode node, Map<GraphNode, GraphNode> map) {
    for (GraphNode nei : node.neighbors) {
      if (!map.containsKey(nei)) {
        GraphNode newNei = new GraphNode(nei.key);
        map.put(nei, newNei);
        dfs(nei, map);
      }
      map.get(node).neighbors.add(map.get(nei));
    }
  }
