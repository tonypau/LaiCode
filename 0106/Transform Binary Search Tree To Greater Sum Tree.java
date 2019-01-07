/*
【302】
Given a BST, change each node’s value, such that its value is equal to the sum of all nodes greater than itself.

Examples:

     11

    /  \

  2     29

 /  \  /  \

1   7 15  40

          /

         35

is transformed to

     119

    /  \

  137    75

 /  \    /  \

139 130 104  0

            /

          40
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

// reverse inorder traverse. its result gives us a decreasing order array
public class Solution {
  public TreeNode greaterSum(TreeNode root) {
    // While traversing we keep track of sum of keys which is the sum of all the keys greater than the key of current node
    int[] sum = new int[1];
    helper(root, sum);
    return root;
  }
  
  private void helper(TreeNode root, int[] sum) {
    if (root == null) return;
    helper(root.right, sum);
    sum[0] += root.key;  // add up sum
    root.key = sum[0] - root.key;  // update key of node
    helper(root.left, sum);
  }
}
