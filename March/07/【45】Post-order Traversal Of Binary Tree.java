/*
Data Structure: Stack, prev node
Initialization: push root into stack, prev = null
For each step:
  cur node is first node in stack
  case1: prev is null or cur is child of prev
        This condition means we have to traverse deeper
        case1.1: when cur has no child, then pop cur
        case1.2: when cur has left child, then push its left child
        case1.3: when cur has right child, then push its right child
        
  case2: prev is right child of cur or prev is left child of cur and cur's right child is null
         This condition means that it's time to pop prev into result
         
  case3: else (prev is the left child of cur and cur's right child is not null)
          This means cur's right child has not been traversed, so push its right child
  
  replace prev with cur until stack is empty
*/

public class Solution {
  public List<Integer> postOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;
    Deque<TreeNode> stack = new LinkedList<>();
    stack.offerFirst(root);
    TreeNode prev = null;
    while (!stack.isEmpty()) {
      TreeNode cur = stack.peekFirst();
      if (prev == null || cur == prev.left || cur == prev.right) {
      // case1
        if (cur.left != null) {
          stack.offerFirst(cur.left);
        } else if (cur.right != null) {
          stack.offerFirst(cur.right);
        } else {
          stack.pollFirst();
          res.add(cur.key);
        }
      } else if (prev == cur.right || prev == cur.left && cur.right == null) {
      // case2
        stack.pollFirst();
        res.add(cur.key);
      } else {
      // case3
        stack.offerFirst(cur.right);
      }
      prev = cur;
    }
    return res;
  }
}
