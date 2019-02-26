// TC: O(height)
// SC: O(height)

public class Solution {
  public TreeNode deleteTree(TreeNode root, int key) {
    if (root == null) return null;
    if (root.key < key) {
      root.right = deleteTree(root.right, key);
    } else if (root.key > key) {
      root.left = deleteTree(root.left, key);
    } else {
      if (root.left == null && root.right == null) {
        return null;
      } else if (root.left == null || root.right == null) {
        return root.left == null ? root.right : root.left;
      } else {
       // replace root with the smallest node larger than it
        TreeNode smallest = findSmallest(root.right);
        root.key = smallest.key;
        // then delete this smallest node
        root.right = deleteTree(root.right, smallest.key);
      }
    }
    return root;
  }
  
  private TreeNode findSmallest(TreeNode root) {
    TreeNode cur = root;
    while (cur.left != null) {
      cur = cur.left;
    }
    return cur;
  }
}
