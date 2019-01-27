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
  public List<Integer> zigZag(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Deque<TreeNode> deque = new LinkedList<>();
    deque.offerLast(root);
    boolean isOdd = true;
    while (!deque.isEmpty()) {
      int size = deque.size();
      if (isOdd) {
        for (int i = 0; i < size; i++) {
          TreeNode cur = deque.pollLast();
          res.add(cur.key);
          if (cur.right != null) {
            deque.offerFirst(cur.right);
          }
          if (cur.left != null) {
            deque.offerFirst(cur.left);
          }
        }
      } else {
        for (int i = 0; i < size; i++) {
          TreeNode cur = deque.pollFirst();
          res.add(cur.key);
          if (cur.left != null) {
            deque.offerLast(cur.left);
          }
          if (cur.right != null) {
            deque.offerLast(cur.right);
          }
        }      
      }
      isOdd = !isOdd;
    }
    return res;
  }
}
