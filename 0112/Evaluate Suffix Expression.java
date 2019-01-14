/*
Evaluate suffix expression, the expression is represented by an String array. 
The elements in the array are either an integer or "+", "-", "*", "/"

Assumptions:

The expression array is not null and it is guaranteed to be a valid infix expression.
Examples:

{"2", "12", "4", "+", "*"} --> 2 * (12 + 4) = 32
*/

public class Solution {
  public int evaluate(String[] suffix) {
    if (suffix == null || suffix.length == 0) return -1;
    Deque<String> stack = new LinkedList<>();
    int res = Integer.valueOf(suffix[0]);
    for (String s : suffix) {
      if (s == "+" || s == "-" || s == "*" || s == "/") {
        int b = Integer.valueOf(stack.pollLast());
        int a = Integer.valueOf(stack.pollLast());
        if (s == "+") res = a + b;
        else if (s == "-") res = a - b;
        else if (s == "*") res = a * b;
        else res = a / b;
        stack.offerLast(String.valueOf(res));
      } else {
        stack.offerLast(s);      
      }
    }
    return res;
  }
}

// I also noticed binary tree is in this problem's flag
// I found every suffix can be contructed in binary tree
public class Solution {
  public TreeNodeP construct(String[] suffix) {
    if (suffix == null || suffix.length == 0) return null;
    Deque<TreeNodeP> stack = new LinkedList<>();
    for (String s : suffix) {
      if (!isOperator(s)) {
        TreeNodeP node = new TreeNodeP(s);
        stack.offerLast(node);
      } else {
        TreeNodeP node = new TreeNodeP(s);
        TreeNodeP right = stack.pollLast();
        TreeNodeP left = stack.pollLast();
        node.left = left;
        node.right = right;
        stack.offerLast(node);
      }
    }
    return stack.peekLast();
  }

  static class TreeNodeP {
    String s;
    TreeNodeP left;
    TreeNodeP right;
    
    TreeNodeP(String s) {
      this.s = s;
    }
  }
}
