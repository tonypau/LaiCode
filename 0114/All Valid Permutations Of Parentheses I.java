public class Solution {
  public List<String> validParentheses(int n) {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    helper(res, sb, n, n);
    return res;
  }
  
  private void helper(List<String> res, StringBuilder sb, int left, int right) {
    if (left == 0 && right == 0) {
      res.add(sb.toString());
      return;
    }
    if (left < right) {
      helper(res, sb.append(")"), left, right - 1);
      sb.deleteCharAt(sb.length() - 1);
    } 
    if (left > 0) {
      helper(res, sb.append("("), left - 1, right);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}

