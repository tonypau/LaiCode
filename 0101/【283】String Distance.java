/*
Given an array of strings, and two different string s and t. We need to return the smallest indices difference between the two given strings.

Return -1 if we can not find s or t in the array.

Assumptions:

The given array is not null, none of the strings in the array is null.
s and t are different and they are not null.
Examples:

array =  {"this", "is", "a", "is", "fox", "happy"}, the distance of "fox" and "is" is 1.
*/

public class Solution {
  public int shortestDistance(String[] words, String word1, String word2) {
    int m = -1;
    int n = -1;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; i++) {
      String s = words[i];
      if (s.equals(word1)) {
        m = i;
        if (n != -1) {
          min = Math.min(min, m - n);
        }
      } else if (s.equals(word2)) {
        n = i;
        if (m != -1) {
          min = Math.min(min, n - m);
        }
      }
    }
    return min;
  }
}
