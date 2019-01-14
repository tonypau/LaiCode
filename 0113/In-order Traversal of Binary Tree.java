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
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Deque<TreeNode> stack = new LinkedList<>();
    pushLeft(root, stack);    
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      res.add(cur.key);
      pushLeft(cur.right, stack);
    }
    return res;
  }
  
  private void pushLeft(TreeNode root, Deque<TreeNode> stack) {
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }
}

