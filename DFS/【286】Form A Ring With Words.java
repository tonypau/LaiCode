public class Solution {
  public boolean formRing(String[] input) {
    if (input == null || input.length == 0) return false;
    return dfs(input, 1);
  }
  
  private boolean dfs(String[] input, int index) {
    if (index == input.length) {
      return canChain(input[index - 1], input[0]);
    }
    for (int i = index; i < input.length; i++) {
      if (canChain(input[index - 1], input[i])) {
        swap(input, i, index);
        if (dfs(input, index + 1)) return true;
        swap(input, i, index);
      }
    }
    return false;
  }
  
  private boolean canChain(String s1, String s2) {
    return s1.charAt(s1.length() - 1) == s2.charAt(0);
  }
  
  private void swap(String[] input, int i, int j) {
    String tmp = input[i];
    input[i] = input[j];
    input[j] = tmp;
  }
}
