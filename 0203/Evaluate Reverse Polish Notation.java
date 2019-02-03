// Recursive version
public class Solution {
  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) return 0;
    if (tokens.length == 1) return Integer.valueOf(tokens[0]);
    int[] back = new int[1];
    back[0] = tokens.length - 1;
    return helper(tokens, back);
  }
  
  private int helper(String[] tokens, int[] back) {
    String str = tokens[back[0]--];
    if (str == "+" || str == "-" || str == "*" || str == "/") {
      int second = helper(tokens, back); 
      int first = helper(tokens, back);            
      switch (str) {
        case "+": 
          return first + second;
        case "-":
          return first - second;
        case "*":
          return first * second;
        default:
          return first / second; 
      }
    } else {
      return Integer.valueOf(str);
    }
  }
}

// Iterative version
public class Solution {
  public int evalRPN(String[] tokens) {
    if (tokens == null || tokens.length == 0) return 0;
    Deque<Integer> stack = new LinkedList<>();
    for (String s : tokens) {
      if (s.equals("/") || s.equals("*") || s.equals("+") || s.equals("-")) {
        int second = stack.pollFirst();
        int first = stack.pollFirst();           
        switch (s) {
          case "+": 
            stack.offerFirst(first + second);
            break;         // Note do not forget break
          case "-":
            stack.offerFirst(first - second);
            break;
          case "*":
            stack.offerFirst(first * second);
            break;
          default:
            stack.offerFirst(first / second);
            break;
        }
      } else {
        stack.offerFirst(Integer.parseInt(s));
      }
    }
    return stack.peek();
  }
}

