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
  public int largestSmaller(TreeNode root, int target) {
    int smallest = Integer.MIN_VALUE;
    while (root != null) {
      if (root.key < target) {
        smallest = root.key;
        root = root.right;
      } else {
        root = root.left;
      }
    }
    return smallest;
  }
}

