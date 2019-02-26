// Method1: 从上往下传值
// TC: O(n)
// SC: O(height)
public class Solution {
  public int maxPathSum(TreeNode root) {
    int[] max = new int[1];
    max[0] = root.key;
    helper(root, 0, max);
    return max[0];
  }
  
  private void helper(TreeNode root, int sum, int[] max) {
    if (root == null) {
      return;
    }
    sum += root.key;
    max[0] = Math.max(max[0], sum);
    if (sum < 0) sum = 0;
    helper(root.left, sum, max);
    helper(root.right, sum, max);
  }
}

// Method2: 从下往上返值
// return the largest sum within its subtree including itself
// TC: O(n)
// SC: O(height)
public class Solution {
  public int maxPathSum(TreeNode root) {
    int[] max = new int[1];
    max[0] = Integer.MIN_VALUE;
    helper(root, max);
    return max[0];
  }
  
  private int helper(TreeNode root, int[] max) {
    if (root == null) return 0;
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    left = Math.max(left, 0);
    right = Math.max(right, 0);
    max[0] = Math.max(max[0], root.key + Math.max(left, right));
    return root.key + Math.max(left, right);
  }
}
