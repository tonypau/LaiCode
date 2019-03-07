/*
Description: 
  The diameter is defined as the longest distance from one leaf node to another leaf node.

Data Structure: node
Initialization: from root to bottom
For each step:
  从下往上返值
    要值：
      分别向左右要值，分别要的是左右子树里最长的从leaf到left child and right child的path
    当前层：
      只有当left path和right path长度都不为0，也就是当前node有左右孩子的时候，也就是这个path存在的时候，才能update max
      
tc: O(n)
sc: O(height)
*/

public class Solution {
  public int diameter(TreeNode root) {
    int[] max = new int[1];
    helper(root, max);
    return max[0];
  }
  
  private int helper(TreeNode root, int[] max) {
    if (root == null) {
      return 0;
    }
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    if (left > 0 && right > 0) {
      max[0] = Math.max(left + right + 1, max[0]);
    }
    return Math.max(left, right) + 1;
  }
}

