/*
Data Structure: node, global count
Initialization: from root to bottom
For each step:
  base case：null的时候，返回true
  从下往上返值：
    返回的是左右子树是否是Univalue Subtree
  当前层做：
    如果左右都是，看一下左右孩子的key是否跟当前node相等，若相等说明以当前node为root的tree也是一个Univalue Subtree，update count。
    要考虑左右孩子是null的情况
      
tc: O(n)
sc: O(height)
*/

public class Solution {
  public int countUnivalSubtrees(TreeNode root) {
    int[] count = new int[1];
    helper(root, count);
    return count[0];
  }
  
  private boolean helper(TreeNode root, int[] count) {
    if (root == null) {
      return true;
    }
    boolean left = helper(root.left, count);
    boolean right = helper(root.right, count);
    if (left && right && (root.left == null || root.left.key == root.key) && (root.right == null || root.right.key == root.key)) {
        count[0]++;
        return true;
    }
    return false;
  }
}
