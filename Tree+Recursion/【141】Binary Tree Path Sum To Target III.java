// TC: O(n)
// SC: O(height)
public class Solution {
  public boolean exist(TreeNode root, int target) {
    Set<Integer> set = new HashSet<>();
    set.add(0);
    return helper(root, target, set, 0);
  }
  
  private boolean helper(TreeNode root, int target, Set<Integer> set, int sum) {
    if (root == null) return false;
    sum += root.key;
    if (set.contains(sum - target)) {
      return true;
    }
    // record whether need to remove cur sum or not
    boolean flag = set.add(sum);
    if (helper(root.left, target, set, sum)) return true;
    if (helper(root.right, target, set, sum)) return true;
    if (flag) set.remove(sum);
    return false;
  }
}
