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
  public List<Integer> preOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Deque<TreeNode> stack = new LinkedList<>();
    stack.offerLast(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pollLast();
      res.add(cur.key);
      if (cur.right != null) stack.offerLast(cur.right);
      if (cur.left != null) stack.offerLast(cur.left);
    }
    return res;
  }
}

