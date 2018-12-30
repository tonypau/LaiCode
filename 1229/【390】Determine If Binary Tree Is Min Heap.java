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

/*
  level order traversal. record whether has met a null node.
*/

public class Solution {
  public boolean isMinHeap(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean isNull = false;
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      if (isNull && cur != null) {
        return false;
      } 
      if (!isNull) {
        if (cur == null) {
          isNull = true;
          continue;
        }
        if (cur.left != null) {
          if (cur.left.key < cur.key) {
            return false;
          } else {
            queue.offer(cur.left);
          }
        } else {
          queue.offer(cur.left);
        }   
        if (cur.right != null) {
          if (cur.right.key < cur.key) {
            return false;
          } else {
            queue.offer(cur.right);
          }
        } else {
          queue.offer(cur.right);
        } 
      }
    }
    return true;
  }
}

