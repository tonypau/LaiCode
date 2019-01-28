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
 
// O(height)
// iterative
public class Solution {
  public int closest(TreeNode root, int target) {
    int closest = root.key;
    while (root != null) {
      if (Math.abs(closest - target) > Math.abs(root.key - target)) {
        closest = root.key;
      }    
      root = root.key < target ? root.right : root.left;
    }
    return closest;
  }
}

// recursive
public class Solution {
  public int closest(TreeNode root, int target) {
    if (root.key == target) return root.key;
    TreeNode next = root.key > target ? root.left : root.right;
    if (next == null) {
      return root.key;
    }
    int res = closest(next, target);
    return Math.abs(res - target) < Math.abs(root.key - target) ? res : root.key;
  }
}
