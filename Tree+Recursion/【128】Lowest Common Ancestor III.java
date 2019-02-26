public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
    if(root == null) return root;
    boolean[] exists = new boolean[2];
    TreeNode answer = helper(root, one, two, exists);
    return exists[0] && exists[1] ? answer : null;
  }
  
  public TreeNode helper(TreeNode root, TreeNode one, TreeNode two, boolean[] exists){
    if(root == null) return root;
    // recursion放在corner case前面，为了走遍tree防止漏掉某一个藏在已找到的node的subtree里的target
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
    if(left != null && right != null) return root;
    else return left != null ? left : right;
  }
}
