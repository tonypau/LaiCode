/*
Data Structure: stack
Initialization: pushLeft(root). 一条道走到黑，把左边的node全压进栈里
For each step:
  pop the first from stack.
  add it into result
  pushLeft(the first node)
  
  
tc: O(n)
sc: O(n) worst case
*/

public class Solution {
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Deque<TreeNode> stack = new LinkedList<>();
    // init
    pushLeft(stack, root);
    
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      res.add(cur.key);
      pushLeft(stack, cur.right);
    }
    return res;
  }
  
  private void pushLeft(Deque<TreeNode> stack, TreeNode root) {
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }
}
