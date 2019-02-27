// TC: O(n)
// SC: O(height)
public class Solution {
  public int maxPathSum(TreeNode root) {
    int[] max = new int[] {Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }
  
  private int helper(TreeNode root, int[] max) {
    if (root == null) {
      return 0;
    }
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    left = Math.max(left, 0);
    right = Math.max(right, 0);
    max[0] = Math.max(max[0], left + right + root.key);
    return left > right ? root.key + left : root.key + right;
  }
}
