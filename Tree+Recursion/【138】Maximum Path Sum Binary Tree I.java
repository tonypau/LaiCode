//TC: O(n)
//SC: O(height)

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
    // only when current root is not leaf, we update max
    if (max[0] < left + right + root.key && root.left != null && root.right != null) {
      max[0] = left + right + root.key;
      return left > right ? root.key + left : root.key + right;
    } else if (root.left != null && root.right != null) {
      return left > right ? root.key + left : root.key + right;
    }
    // when left or right is null, we give up the null side
    return root.left == null ? root.key + right : root.key + left;
  }
}
