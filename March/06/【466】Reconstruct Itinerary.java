// tc: O() ？？
public class Solution {
  public List<String> findItinerary(String[][] tickets) {
    List<String> res = new ArrayList<>();
    Map<String, Map<String, Integer>> graph = new HashMap<>();
    buildGraph(tickets, graph);
    dfs("JFK", res, graph, tickets.length + 1);
    return res;
  }
  
  private boolean dfs(String node, List<String> res, Map<String, Map<String, Integer>> graph, int size) {
    res.add(node);
    if (res.size() == size) return true;
    if (graph.containsKey(node)) {
      Map<String, Integer> children = graph.get(node);
      for (String child : children.keySet()) {
        if (children.get(child) > 0) {
          children.put(child, children.get(child) - 1);
          if (dfs(child, res, graph, size)) return true;
          children.put(child, children.get(child) + 1);
        }      
      }
    }
    res.remove(res.size() - 1);
    return false;
  }
  
  private void buildGraph(String[][] tickets, Map<String, Map<String, Integer>> graph) {
    for (String[] ticket : tickets) {
      String start = ticket[0];
      String end = ticket[1];
      if (!graph.containsKey(start)) {
        Map<String, Integer> children = new TreeMap<>();
        graph.put(start, children);
      }
      if (!graph.get(start).containsKey(end)) {
        graph.get(start).put(end, 1);  
      } else {
        graph.get(start).put(end, graph.get(start).get(end) + 1);
      }
    }
  }
}
