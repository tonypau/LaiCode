/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

public class Solution {
  public String longestCommonPrefix(String[] strs) {
    // corner cases
    if (strs == null) return null;
    if (strs.length == 0) return "";
    
    String res = "";
    // get the minLen among the strings
    int minLen = Integer.MAX_VALUE;
    for (String s : strs) {
      if (s.length() < minLen) minLen = s.length();
    }
    // travese every character at the same position amongst all strings.
    for (int i = 0; i < minLen; i++) {
      for (int j = 0; j < strs.length - 1; j++) {
        String s1 = strs[j];
        String s2 = strs[j + 1];
        // if meet two different, then return directly
        if (s1.charAt(i) != s2.charAt(i)) {
          return s1.substring(0, i);
        }
      }
    }
    // outside the for-loop, so return minLen substring
    return strs[0].substring(0, minLen);
  }
}
