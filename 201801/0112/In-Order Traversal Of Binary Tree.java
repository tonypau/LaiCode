[43]

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
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) return list;
    Deque<TreeNode> stack = new LinkedList<>();
    // init
    pushLeft(root, stack);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pollLast();
      list.add(cur.key);
      // push cur's right subtree
      pushLeft(cur.right, stack);
    }
    return list;
  }
  
  private void pushLeft(TreeNode root, Deque<TreeNode> stack) {
    while (root != null) {
      stack.offerLast(root);
      root = root.left;
    }
  }
}

