/*
Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node to any node (the start node and the end node can be the same). 

Assumptions

The root of the given binary tree is not null
Examples

   -1

  /    \

2      11

     /    \

    6    -14

one example of paths could be -14 -> 11 -> -1 -> 2

another example could be the node 11 itself

The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18

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

public class Solution {
  public int maxPathSum(TreeNode root) {
    int[] max = new int[]{Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }
  
  private int helper(TreeNode root, int[] max) {
    if (root == null) {
      return 0;  
    }
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    // if < 0, we do not add it with cur node key
    left = left < 0 ? 0 : left;
    right = right < 0 ? 0 : right;
    int sum = left + right + root.key;
    max[0] = Math.max(sum, max[0]);
    // return value should be only one path in order to be able to concatenate with parent node
    return Math.max(left, right) + root.key;
  }
}

