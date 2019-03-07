/*
Data Structure: global max
Initialization: global max = MIN_VALUE
For each step:
  从下往上返值：
    返回的是包含当前节点的子节点在内的直到leaf的path的最大sum
  当前层：
    首先只有当左右孩子都不为null的时候，才能update global max
    其次，处理向上返回值的时候，要整理清楚孩子是null的情况
    
tc: O(n)
sc: O(height)
*/

public class Solution {
  public int maxPathSum(TreeNode root) {
    if (root == null) return Integer.MIN_VALUE;
    int[] max = new int[] {Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }
  
  private int helper(TreeNode root, int[] max) {
    if (root == null) {
      return 0;  
    }
    // Ask for what from lower levels?
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    
    // what to do in current level?
    if ((left != 0 || root.left != null) && (right != 0 || root.right != null)) {
      max[0] = Math.max(max[0], left + right + root.key);
    }
    
    // what to return to upper level?
    if (root.left != null && root.right != null) {
      return Math.max(left, right) + root.key;  
    }
    return root.left == null ? right + root.key : left + root.key;
  }
}
