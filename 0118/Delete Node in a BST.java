/*
[leetcode450]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
      if (root == null) return null;
      if (root.val == key) {
        return helper(root.right, root.left); 
      }
      TreeNode prev = null;
      TreeNode cur = root;
      while (cur != null) {
        if (cur.val == key) {
          break;
        } else if (cur.val < key) {
          prev = cur;
          cur = cur.right;
        } else {
          prev = cur;
          cur = cur.left;          
        }
      }
      if (cur == null) return root;
      if (cur == prev.left) {
        prev.left = helper(cur.right, cur.left);
      } 
      if (cur == prev.right) {
        prev.right = helper(cur.right, cur.left);
      }
      return root;
    }
  
  private TreeNode helper(TreeNode one, TreeNode two) {
    if (one == null) return two;
    if (two == null) return one;
    TreeNode cur = one;
    while (cur.left != null) cur = cur.left;
    cur.left = two;
    return one;
  }
}
