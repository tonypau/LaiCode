/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.  

Example

")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

public class Solution {
  public int longestValidParentheses(String input) {
    Deque<int[]> stack = new LinkedList<>();
    int res = 0;
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c == '(') {
        stack.offerLast(new int[]{i, 0});
      } else {
        if (stack.isEmpty() || stack.peekLast()[1] == 1) {
          stack.offerLast(new int[]{i, 1});
        } else {
          stack.pollLast();
          int cur = 0;
          if (stack.isEmpty()) {
            cur = i + 1;
          } else {
            cur = i - stack.peekLast()[0];
          }
          res = Math.max(res, cur);
        }
      }
    }
    return res;
  }
}
