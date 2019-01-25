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
  public boolean exist(TreeNode root, int target) {
    Set<Integer> set = new HashSet<>();
    set.add(0);
    return helper(root, target, 0, set);
  }
  
  private boolean helper(TreeNode root, int target, int sum, Set<Integer> set) {
    if (root == null) {
      return false;
    }
    sum += root.key;
    if (set.contains(sum - target)) {
      return true;
    }
    // avoid deleting previous added sum
    boolean flag = set.add(sum);
    if (helper(root.left, target, sum, set)) return true;
    if (helper(root.right, target, sum, set)) return true;
    if (flag) set.remove(sum);
    return false;
  }
}

