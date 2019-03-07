/*
Data Structure: boolean[] exists: record whether the two target has been met
Initialization: boolean[] exists = [false, false]
For each step:
  从下向上返值：
    返回的是子树里的LCA
    
  当前层：
    比较left和right，都有值则当前root是LCA，否则返回其中非空者
    recursion之后多加一个判断，update exists boolean array
    这里要注意，为什么不加在recursion之前？ 因为这样就不能遍历完整棵树从而可能漏掉出现在target之下的另一个target导致最终结果出错
    
tc: O(n)
sc: O(height)
*/

public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
    boolean[] exists = new boolean[2];
    TreeNode res = helper(root, one, two, exists);
    return exists[0] && exists[1] ? res : null;
  }
  
  private TreeNode helper(TreeNode root, TreeNode one, TreeNode two, boolean[] exists) {
    if (root == null) {
      return null;
    }
    TreeNode left = helper(root.left, one, two, exists);
    TreeNode right = helper(root.right, one, two, exists);
    if (root == one) {
      exists[0] = true;
      return root;
    }
    if (root == two) {
      exists[1] = true;
      return root;
    }
    if (left != null && right != null) {
      return root;
    }
    return left == null ? right : left;
  }
}
