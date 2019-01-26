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
  public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
    Set<TreeNode> set = new HashSet<>();
    for (TreeNode node : nodes) set.add(node);
    return helper(root, set);
  }
  
  private TreeNode helper(TreeNode root, Set<TreeNode> set) {
    if (root == null || set.contains(root)) {
      return root;
    }
    TreeNode left = helper(root.left, set);
    TreeNode right = helper(root.right, set);
    if (left == null && right == null) {
      return null;
    } else if (left == null || right == null) {
      return left == null ? right : left;
    } else {
      return root;
    }
  }
}
