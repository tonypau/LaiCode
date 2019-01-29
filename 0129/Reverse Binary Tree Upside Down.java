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
  public TreeNode reverse(TreeNode root) {
    if (root == null || root.left == null) {
      return root;
    }
    TreeNode newRoot = reverse(root.left);
    root.left.left = root;  // need check null of root.left before
    root.left.right = root.right;
    root.right = null;
    root.left = null;
    return newRoot;
  }
}

