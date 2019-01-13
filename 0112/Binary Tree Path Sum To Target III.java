/*
Given a binary tree in which each node contains an integer number. 
Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), 
the sum of the numbers on the path is the given target number.

Examples

    5

  /    \

2      11

     /    \

    6     14

  /

 3

If target = 17, There exists a path 11 + 6, the sum of the path is target.

If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.

If target = 10, There does not exist any paths sum of which is target.

If target = 11, There exists a path only containing the node 11.

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

// the path can only be from one node to itself or to any of its descendants
public class Solution {
  public boolean exist(TreeNode root, int target) {
    Set<Integer> set = new HashSet<>();
    set.add(0);
    return helper(root, target, set, 0);
  }
  
  private boolean helper(TreeNode root, int target, Set<Integer> set, int sum) {
    if (root == null) return false;
    sum += root.key;
    // we need to check if sum can be inserted into the set 
    // in order to decide whether or not remove it after deeping down recursion
    boolean needRemove = set.add(sum);
    if (set.contains(sum - target)) return true;
    if (helper(root.left, target, set, sum)) return true;
    if (helper(root.right, target, set, sum)) return true;
    if (needRemove) set.remove(sum);  
    return false;
  }
}

