/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values, 
from left to right. Only need to return lowest level 

Example:

    Given the below binary tree

              5

          /        \

        3          8

      /    \           \

    1       4         11

    return its bottom-up level order traversal as:

      [1, 4, 11],


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
 
public class Solution {
  public List<Integer> levelOrderBottom(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    int height = getHeight(root);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int level = 1;
    while (!queue.isEmpty()) {
      if (level == height) {
        for (TreeNode node : queue) {
          res.add(node.key);
        }
        break;
      }
      int size = queue.size();
      level++;
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
    }
    return res;
  }
  
  private int getHeight(TreeNode root) {
    if (root == null) return 0;
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    return Math.max(left, right) + 1;
  }
}

