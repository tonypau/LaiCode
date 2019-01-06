/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 <=k <= BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
How would you optimize the kthSmallest routine?
*/

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
 
// sol1: use inorder traversal 
public class Solution {
  public int kthSmallest(TreeNode root, int k) {
    int[] count = new int[]{k};
    int[] res = new int[1];
    helper(root, count, res);
    return res[0];
  }
  
  private void helper(TreeNode root, int[] count, int[] res) {
    if (root == null) return;
    helper(root.left, count, res);
    count[0]--;
    if (count[0] == 0) {
      res[0] = root.key;
      return;
    }
    helper(root.right, count, res);
  }
}

// sol2: add one more field to each node which means the count of nodes in the node's subtree
// in this solution, we build a new augmented data structure.
// we can also modify directly on previous TreeNode.
public class Solution {
  static class TreeNodeC {
    int key;
    int count = 1;
    TreeNodeC left;
    TreeNodeC right;
    TreeNodeC(int key) {
      this.key = key;
    }
  }
  
  public int kthSmallest(TreeNode root, int k) {
    TreeNodeC rootC = build(root);
    return kthSmallest(rootC, k);
  }
  
  private int kthSmallest(TreeNodeC rootC, int k) {
    if (k <= 0 || k > rootC.count) return -1;
    if (rootC.left != null) {
      if (rootC.left.count == k - 1) return rootC.key;
      else if (rootC.left.count > k - 1) return kthSmallest(rootC.left, k);
      else return kthSmallest(rootC.right, k - 1 - rootC.left.count);
    } else {
      if (k == 1) return rootC.key;
      return kthSmallest(rootC.right, k - 1);
    }
  }
  
  private TreeNodeC build(TreeNode root) {
    if (root == null) return null;
    TreeNodeC rootC = new TreeNodeC(root.key);
    rootC.left = build(root.left);
    rootC.right = build(root.right);
    if (rootC.left != null) rootC.count += rootC.left.count;
    if (rootC.right != null) rootC.count += rootC.right.count;
    return rootC;
  }
}
