/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  static class Cell {
    int level;
    TreeNode node;
    Cell(TreeNode node, int level) {
      this.level = level;
      this.node = node;
    }
  }
  
  public List<Integer> verticalOrder(TreeNode root) {
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Queue<Cell> queue = new LinkedList<>();
    queue.offer(new Cell(root, 0));
    int min = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Cell cur = queue.poll();
        min = Math.min(min, cur.level);
        List<TreeNode> list = map.get(cur.level);
        if (list != null) {
          list.add(cur.node);
          map.put(cur.level, list);
        } else {
          List<TreeNode> l = new ArrayList<>();
          l.add(cur.node);
          map.put(cur.level, l);
        }
        if (cur.node.left != null) {
          queue.add(new Cell(cur.node.left, cur.level - 1));
        }
        if (cur.node.right != null) {
          queue.add(new Cell(cur.node.right, cur.level + 1));
        }
      }
    }
    convert(map, res, min);
    return res;
  }
  
  private void convert(Map<Integer, List<TreeNode>> map, List<Integer> res, int min) {
    for (int i = min; i < min + map.size(); i++) {
      for (TreeNode node : map.get(i)) {
        res.add(node.key);
      }
    }
  }
}

