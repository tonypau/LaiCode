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
 
// 建树类型的recursion。返回值直接搭到左右孩子上
public class Solution {
  public TreeNode deleteTree(TreeNode root, int key) {
    if (root == null) return root;
    if (root.key == key) {
      TreeNode candidate = findSmallestLarger(root);
      if (candidate == null) return root.left; // 当要删除的node没有右子树，直接返回左子树
      root.key = candidate.key;
      root.right = deleteTree(root.right, candidate.key);  // 把candidate删了
    } else if (root.key < key) {
      root.right = deleteTree(root.right, key);
    } else {
      root.left = deleteTree(root.left, key);
    }
    return root;
  }
  
  private TreeNode findSmallestLarger(TreeNode root) {
    TreeNode cur = root.right;
    if (cur == null) return null;
    while (cur.left != null) {
      cur = cur.left;
    }
    return cur;
  }
}

