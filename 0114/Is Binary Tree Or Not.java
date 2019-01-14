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
 
 // time O(n) loop each node
 // space O(n) worst case
public class Solution {
  public boolean isBST(TreeNode root) {
    return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  private boolean helper(TreeNode root, int min, int max) {
    if (root == null) return true;
    if (root.key >= max || root.key <= min) {
      return false;
    }
    return helper(root.left, min, root.key) && helper(root.right, root.key, max);
  }
}

