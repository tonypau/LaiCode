/*
Data Structure: global max
Initialization: global max = MIN_VALUE
For each step:
  从下往上返值：
    返回的是包含当前节点的子节点在内的最大sum
    
  当前层：
    摒弃掉<0的左右值，update max
    
  向上：
    传root.key + 左右值里大的那个
tc:
sc:
*/

public class Solution {
  public int maxPathSum(TreeNode root) {
    int[] max = new int[] {Integer.MIN_VALUE};
    helper(root, max);
    return max[0];
  }
  
  private int helper(TreeNode root, int[] max) {
    if (root == null) {
      return 0;  
    }
    int left = helper(root.left, max);
    int right = helper(root.right, max);
    left = left > 0 ? left : 0;
    right = right > 0 ? right : 0;
    max[0] = Math.max(max[0], left + right + root.key);
    return left > right ? root.key + left : root.key + right;
  }
}

