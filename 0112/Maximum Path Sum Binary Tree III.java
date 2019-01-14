/*
[140]
Given a binary tree in which each node contains an integer number. Find the maximum possible subpath sum(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, and the subpath is allowed to contain only one node).

Assumptions

The root of given binary tree is not null
Examples

   -5

  /    \

2      11

     /    \

    6     14

           /

        -3

The maximum path sum is 11 + 14 = 25

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4
*/

// pass down value
public class Solution {
  public int maxPathSum(TreeNode root) {
    // Write your solution here
    int[] max = new int[1];
    max[0] = Integer.MIN_VALUE;
    helper(root, 0, max);
    return max[0];
  }
  
  private void helper(TreeNode root, int sum, int[] max) {
    if (root == null) return;
    sum += root.key;
    max[0] = Math.max(sum, max[0]);
    if (sum < 0) sum = 0;
    helper(root.left, sum, max);
    helper(root.right, sum, max);
  }
}

