public class Solution {
  private static char[] P = new char[]{'(',')','<','>','{','}'};
  
  public List<String> validParentheses(int l, int m, int n) {
    List<String> res = new ArrayList<>();
    // great little trick, can avoid lots of if check
    int[] remain = new int[] {l, l, m, m, n, n};
    int targetLen = 2 * (l + m + n);
    StringBuilder sb = new StringBuilder();
    Deque<Character> stack = new LinkedList<>();
    helper(res, stack, sb, remain, targetLen, 0);
    return res;
  }
  
  private void helper(List<String> res, Deque<Character> stack, StringBuilder sb, int[] remain, int targetLen, int len) {
    if (len == targetLen) {
      res.add(sb.toString());
      return;
    }
    for (int i = 0; i < P.length; i++) {
      if (i % 2 == 0) {
        if (remain[i] > 0) {
        // offer first
          stack.offerLast(P[i]);
          sb.append(P[i]);
          remain[i]--;
          helper(res, stack, sb, remain, targetLen, len + 1);
          remain[i]++;
          sb.deleteCharAt(sb.length() - 1);
        // poll last
          stack.pollLast();
        }
      } else {
        if (!stack.isEmpty() && stack.peekLast() == P[i - 1]) {
        // poll first
          stack.pollLast();
          sb.append(P[i]);
          remain[i]--;
          helper(res, stack, sb, remain, targetLen, len + 1);
          remain[i]++;
          sb.deleteCharAt(sb.length() - 1);
        //offer last
          stack.offerLast(P[i - 1]);
        }
      }
    }
  }
}

