public class Solution {
  public List<String> subSets(String set) {
    List<String> res = new ArrayList<>();
    if (set == null) return res;
    StringBuilder sb = new StringBuilder();
    char[] arr = set.toCharArray();
    helper(res, sb, arr, 0);
    return res;
  }
  
  private void helper(List<String> res, StringBuilder sb, char[] arr, int level) {
    if (level == arr.length) {
      res.add(sb.toString());
      return;
    }
    sb.append(arr[level]);
    helper(res, sb, arr, level + 1);
    sb.deleteCharAt(sb.length() - 1);
    helper(res, sb, arr, level + 1);
  }
}

