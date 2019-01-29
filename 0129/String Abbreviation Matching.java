public class Solution {
  public boolean match(String input, String pattern) {
    int i = 0;
    int j = 0;
    while (i < input.length() && j < pattern.length()) {
      if (pattern.charAt(j) >= '0' && pattern.charAt(j) <= '9') {
        int begin = j;
        // get number
        int length = 0;
        while (begin < pattern.length() && pattern.charAt(begin) >= '0' && pattern.charAt(begin) <= '9') {
          length += length * 10 + pattern.charAt(begin) - '0';
          begin++;
        }
        j = begin;
        i += length;
      } else if (input.charAt(i) != pattern.charAt(j)) {
        return false;
      } else {
        i++;
        j++;
      }
    }
    // only when i and j move out at the same time, return true
    if (i == input.length() && j == pattern.length())  return true;
    else return false;
  }
}
