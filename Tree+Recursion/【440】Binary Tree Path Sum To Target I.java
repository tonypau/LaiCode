// TC: O(n)
// SC: O(height)
public class Solution {
  public boolean exist(TreeNode root, int target) {
    if (root == null) return false;
    return helper(root, target);
  }
  
  private boolean helper(TreeNode root, int target) {
    if (root == null && target == 0) {
      return true;  
    } else if (root == null) {
      return false;
    }
    boolean left = helper(root.left, target - root.key);
    boolean right = helper(root.right, target - root.key);
    return left || right;
  }
}
