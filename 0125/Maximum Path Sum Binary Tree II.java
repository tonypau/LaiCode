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
  public int maxPathSum(TreeNode root) {
    int[] max = new int[1];
    max[0] = Integer.MIN_VALUE;
    helper(root, max);
    return max[0];
  }
  
  private int helper(TreeNode root, int[] max) {
    if (root == null) {
      return 0;
    } 
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    left = left < 0 ? 0 : left;
    right = right < 0 ? 0 : right;
    max[0] = Math.max(max[0], left + right + root.key);
    return Math.max(root.key + left, root.key + right);
  }
}

