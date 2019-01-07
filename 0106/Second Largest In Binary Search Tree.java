/*
【347】
Find the second largest key in the given binary search tree.

If there does not exist the second largest key, return Integer.MIN_VALUE.

Assumptions:

The given binary search tree is not null.
Examples:

    2

  /   \

 1     4

      /

    3

the second largest key is 3.
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
public class Solution {
  public int secondLargest(TreeNode root) {
		
    TreeNode cur = root;
		
    while (cur.left != null || cur.right != null) {
      
      // when cur has no right child but has left child
      // we find the largest one in its left child
      if (cur.left != null && cur.right == null) {
        return largest(cur.left);
      }
      
      // when cur has right child but its right child has neight left or right child, 
      // then cur is the second largest we need
      if (cur.right != null && cur.right.left == null && cur.right.right == null) {
        return cur.key;
      }
      cur = cur.right;
    }
		
    return Integer.MIN_VALUE;
  }
	
  private int largest(TreeNode root) {
    TreeNode cur = root;
    while (root.right != null) {
      root = root.right;
    }
    return root.key;
  }
}

