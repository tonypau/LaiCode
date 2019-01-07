/*
【368】
Given two keys in a binary search tree, find their lowest common ancestor.

Assumptions

There is no parent pointer for the nodes in the binary search tree

There are no duplicate keys in the binary search tree

The given two nodes are guaranteed to be in the binary search tree

Examples

        5

      /   \

     2     12

   /  \      \

  1    3      14

The lowest common ancestor of 1 and 14 is 5

The lowest common ancestor of 1 and 3 is 2
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
 
// with property of bst, in preorder traverse, the first node larger than p and smaller than q is the result

public class Solution {
  public TreeNode lca(TreeNode root, int p, int q) {
    if (root == null) return root;
    if (p > q) return helper(root, q, p);
    return helper(root, p, q);
  }
  
  private TreeNode helper(TreeNode root, int p, int q) {
    if (root.key > p && root.key > q) {
      return helper(root.left, p, q);
    }
    if (root.key < p && root.key < q) {
      return helper(root.right, p, q); 
    }
    return root;
  }
}
