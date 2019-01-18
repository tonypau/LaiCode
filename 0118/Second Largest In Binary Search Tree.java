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
  public int secondLargest(TreeNode root) {
    if (root.left == null && root.right == null) {
      return Integer.MIN_VALUE;
    }
    TreeNode prev = null;
    TreeNode cur = root;
    while (cur.right != null) {
      prev = cur;
      cur = cur.right;
    }
    if (cur.left == null && cur.right == null) {
      return prev.key;
    }
    if (cur.right == null) {
      cur = cur.left;
      while (cur.right != null) {
        cur = cur.right;
      }
      return cur.key;
    }
    return Integer.MIN_VALUE;
  }
}

