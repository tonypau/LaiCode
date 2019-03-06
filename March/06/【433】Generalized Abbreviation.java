public class Solution {
  public List<String> generateAbbreviations(String word) {
    if (word == null || word.length() == 0) {
      return new ArrayList<String>();
    }
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    dfs(0, res, word, sb, 0);
    return res;
  }
  
  private void dfs(int index, List<String> res, String word, StringBuilder sb, int count) {
    int len = sb.length();
    if (index == word.length()) {
      if (count != 0) {
        sb.append(count);
      }
      res.add(sb.toString());
      sb.setLength(len);
      return;
    }
    dfs(index + 1, res, word, sb, count + 1);
    if (count > 0) {
      sb.append(count);
    }
    sb.append(word.charAt(index));
    dfs(index + 1, res, word, sb, 0);
    sb.deleteCharAt(sb.length() - 1);
    sb.setLength(len);
  }
}

