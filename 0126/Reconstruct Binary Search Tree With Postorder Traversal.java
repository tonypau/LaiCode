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
  public TreeNode reconstruct(int[] post) {
    int[] index = new int[]{post.length - 1};
    return helper(post, index, Integer.MIN_VALUE);
  }
  
  private TreeNode helper(int[] post, int[] index, int min) {
    if (index[0] < 0 || post[index[0]] < min) {
      return null;
    } 
    TreeNode root = new TreeNode(post[index[0]--]);
    // NOTICE the order, 先右后左,因为是从右向左遍历post,势必是先遇到右孩子再遇到左孩子
    root.right = helper(post, index, root.key);
    root.left = helper(post, index, min);
    return root;
  }
}

