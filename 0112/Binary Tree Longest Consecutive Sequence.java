/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,

   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
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
 
// sol1: pass down value to child and update global max
public class Solution {
  public int longestConsecutive(TreeNode root) {
    if (root == null) return 0;
    int[] max = new int[]{1};
    helper(root.left, root.key, 1, max);
    helper(root.right, root.key, 1, max);
    return max[0];
  }
  
  private void helper(TreeNode root, int parentValue, int length, int[] max) {
    if (root == null) return;
    if (parentValue == root.key - 1) {
      length = length + 1;
    } else {
      length = 1;
    }
    max[0] = Math.max(max[0], length);
    helper(root.left, root.key, length, max);
    helper(root.right, root.key, length, max);
  }
}

// sol2: ask for value from child
public class Solution {
  public int longestConsecutive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }
    int left = longestConsecutive(root.left);
    int right = longestConsecutive(root.right);
    if (root.left != null && root.left.key == root.key + 1) left++;
    if (root.right != null && root.right.key == root.key + 1) right++;
    return Math.max(left, right);
  }
}


