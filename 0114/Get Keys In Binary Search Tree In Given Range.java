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
 //iterative
public class Solution {
  public List<Integer> getRange(TreeNode root, int min, int max) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Deque<TreeNode> stack = new LinkedList<>();
    pushLeft(stack, root, min, max);
    while (!stack.isEmpty() && stack.peekLast().key <= max) {
      TreeNode cur = stack.pollLast();
      if (cur.key >= min) res.add(cur.key);
      pushLeft(stack, cur.right, min, max);
    } 
    return res;
  }
  
  private void pushLeft(Deque<TreeNode> stack, TreeNode root, int min, int max) {
    while (root != null) {
      stack.offerLast(root);
      root = root.left;
    }
  }
}
// recursive
public class Solution {
  public List<Integer> getRange(TreeNode root, int min, int max) {
    List<Integer> res = new ArrayList<>();
    getRange(root, min, max, res);
    return res;
  }
  
  private void getRange(TreeNode root, int min, int max, List<Integer> res) {
    if (root == null) {
      return;
    }
    if (root.key >= min) {
      getRange(root.left, min, max, res);
    }
    if (root.key >= min && root.key <= max) {
      res.add(root.key);
    }
    if (root.key <= max) {
      getRange(root.right, min, max, res);
    }
  }
}

