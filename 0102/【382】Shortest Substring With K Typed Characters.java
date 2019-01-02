/*
Given a string, return the shortest contiguous substring that contains exactly k type of characters.

Return an empty string if there does not exist such substring.

Assumptions:

The given string is not null.
k >= 0.
Examples:

input = "aabcc", k = 3, output = "abc".
input = "aabbbcccc", k = 3, output = "abbbc".
input = "aabcc", k = 4, output = "".
*/


public class Solution {
  public String shortest(String input, int k) {
    // multiple corner cases
    if (input == null ) return null;
    if (k == 0 || input.length() < k) return "";
    
    char[] arr = input.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    int left = 0;
    int count = 0;
    int minLen = Integer.MAX_VALUE;
    String res = "";
    for (int i = 0; i < arr.length; i++) {
      Integer num = map.get(arr[i]);
      if (num != null) {
        if (num == 0) {
          count++;
        }
        map.put(arr[i], num + 1);
      } else {
        count++;
        map.put(arr[i], 1);
      }
      // update left bound to decrease the length of the sliding window
      while (count == k) {
        if (minLen > i - left + 1) {
          minLen = i - left + 1;
          res = input.substring(left, i + 1);
        }
        Integer n = map.get(arr[left]);
        if (n == 1) {
          count--;
        }
        map.put(arr[left], n - 1);
        left++;
      }
    }
    return res;
  }
}

