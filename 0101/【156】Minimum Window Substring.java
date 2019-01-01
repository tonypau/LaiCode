/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T

Input: S = “ADOBECODEBANC”

          T = “ABC”

Output: “BANC”
*/

public class Solution {
  public String minWindow(String source, String target) {
    char[] s = source.toCharArray();
    char[] t = target.toCharArray();
    // letters appeared in target and the number of appearance
    Map<Character, Integer> map = new HashMap<>();
    for (char c : t) {
      Integer i = map.get(c);
      if (i == null) {
        map.put(c, 1);
      } else {
        map.put(c, i + 1);
      }
    }
    // left bound of the window
    int left = 0;
    // window length
    int minLen = Integer.MAX_VALUE;
    // record the number of successfully matched letters
    int count = 0;
    // results
    String res = source;
    for (int i = 0; i < s.length; i++) {
      Integer num = map.get(s[i]);
      if (num != null) {
        // num > 0 means successfully matched
        if (num > 0) {
          count++;
        }
        // so num - 1 remaining to match
        map.put(s[i], num - 1);
      }
      while (count == t.length) {
        // comparing the min length of the window
        if (minLen > i - left + 1) {
          minLen = i - left + 1;
          res = source.substring(left, i + 1);
        }
        if (left >= s.length) break;
        Integer n = map.get(s[left]);
        if (n != null) {
          // in map, only when number >= 0, count--
          if (n + 1 > 0) {
            count--;
          }
          map.put(s[left], n + 1);
        }
        left++;
      }
    }
    return res;
  }
}
