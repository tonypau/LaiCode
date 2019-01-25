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
    max[0] = root.key;
    helper(root, 0, max);
    return max[0];
  }
  
  private void helper(TreeNode root, int sum, int[] max) {
    if (root == null) return;
    sum += root.key;    
    max[0] = Math.max(max[0], sum);

    if (sum < 0) sum = 0;
    helper(root.left, sum, max);
    helper(root.right, sum, max);
  }
}

