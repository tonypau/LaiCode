public class Solution {
  public List<String> subSets(String set) {
    List<String> res = new ArrayList<>();
    if (set == null) return res;
    StringBuilder sb = new StringBuilder();
    char[] arr = set.toCharArray();
    Arrays.sort(arr);
    helper(res, arr, sb, 0);
    return res;
  }
  
  private void helper(List<String> res, char[] arr, StringBuilder sb, int index) {
    if (index == arr.length) {
      res.add(sb.toString());
      return;
    }
    sb.append(arr[index]);
    helper(res, arr, sb, index + 1);
    sb.deleteCharAt(sb.length() - 1);
    while (index + 1 < arr.length && arr[index + 1] == arr[index]) {
      index++;
    }
    helper(res, arr, sb, index + 1);
  }
}
