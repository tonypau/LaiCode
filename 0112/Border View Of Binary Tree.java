[316]

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
  public List<Integer> borderView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    res.add(root.key);
    traverseL(root.left, res);
    traverseC(root.left, res);
    traverseC(root.right, res);
    traverseR(root.right, res);
    return res;
  }
  
  // preorder
  private void traverseL(TreeNode root, List<Integer> res) {
    // base case: not include the leftmost element which also in the leaves node
    if (root == null || root.left == null && root.right == null) {
      return;
    }
    res.add(root.key);
    if (root.left != null) {
      traverseL(root.left, res);
    } else {
      traverseL(root.right, res);
    }
  }
  
  // preorder 
  private void traverseC(TreeNode root, List<Integer> res) {
    if (root == null) return;
    if (root.left == null && root.right == null) {
      res.add(root.key);
      return;
    }
    traverseC(root.left, res);
    traverseC(root.right, res);
  }
  
  // postorder
  private void traverseR(TreeNode root, List<Integer> res) {
    if (root == null || root.left == null && root.right == null) {
      return;
    }
    if (root.right != null) {
      traverseL(root.right, res);
    } else {
      traverseL(root.left, res);
    }
    res.add(root.key);
  }
}
