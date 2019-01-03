/*
Determine if two given Strings are one edit distance.

One edit distance means you can only insert one character/delete one character/replace one character to another character in one of the two given Strings and they will become identical.

Assumptions:

The two given Strings are not null
Examples:

s = "abc", t = "ab" are one edit distance since you can remove the trailing 'c' from s so that s and t are identical

s = "abc", t = "bcd" are not one edit distance
*/


public class Solution {
  public boolean oneEditDistance(String source, String target) {
    if (source == null || target == null) {
      return false;
    }
    int m = source.length();
    int n = target.length();
    if (Math.abs(m - n) > 1) return false;
    int i = 0;
    int j = 0;
    int count = 0;
    while (i < m && j < n) {
      if (source.charAt(i) == target.charAt(j)) {
        i++;
        j++;
      } else {
        count++;
        if (count > 1) {
          return false;
        } else {
          if (m > n) i++;
          else if (m < n) j++;
          else {i++; j++;}
        }
      }
    }
    if (i < m || j < n) count++;
    if (count == 1) return true;
    return false;
  }
}

