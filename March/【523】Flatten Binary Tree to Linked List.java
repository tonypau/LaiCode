/*
Data Structure:  node, recursion
Initialization: 
For each step:
  first get the root of left part and the root of right part
  then do something connect left part to right and right part to the tail of left part
  反转链表思想。不往深了想，用比自己小一号问题来解决当前层问题
  包括那道tree转双向链表也是一个道理
tc: O(n)
sc: O(height)
*/

public class Solution {
  public TreeNode flatten(TreeNode root) {
    if (root == null) {
      return null;  
    }
    TreeNode left = flatten(root.left);
    TreeNode tmp = left;
    while (tmp != null && tmp.right != null) {
      tmp = tmp.right;
    }
    TreeNode right = flatten(root.right);
    if (tmp != null) {
      tmp.right = right;
      root.right = left;
      root.left = null;
    } 
    return root;
  }
}
