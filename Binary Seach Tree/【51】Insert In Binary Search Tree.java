// TC: O(height)
// SC: O(height)

// recursion 
public class Solution {
  public TreeNode insert(TreeNode root, int key) {
    if (root == null) return new TreeNode(key);
    if (root.key == key) {
      return root;
    } else if (root.key < key) {
      root.right = insert(root.right, key);
    } else {
      root.left = insert(root.left, key);
    }
    return root;
  }
}
