/*
Given two strings s1 and s2, find the shortest substring in s1 containing all characters in s2.

If there does not exist such substring in s1, return an empty string.

Assumptions:

s1 and s2 are not null or empty.
Examples:

s1= “The given test strings”

s2: “itsst”

Output string: “st stri”
*/


public class Solution {
  public String smallest(String s1, String s2) {
    Map<Character, Integer> map = new HashMap<>();
    char[] arr2 = s2.toCharArray();
    for (char c : arr2) {
      Integer num = map.get(c);
      if (num != null) {
        map.put(c, num + 1);
      } else {
        map.put(c, 1);
      }
    }
    char[] arr = s1.toCharArray();
    int left = 0;
    String res = "";
    int count = 0;
    int minLen = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      Integer num = map.get(arr[i]);
      if (num != null) {
        // NOTICE check
        if (num > 0) {
          count++;
        }
        map.put(arr[i], num - 1);
      }
      while (count == arr2.length) {
        if (minLen > i - left + 1) {
          minLen = i - left + 1;
          res = s1.substring(left, i + 1);
        }
        Integer n = map.get(arr[left]);
        if (n != null) {
          // NOTICE check
          if (n >= 0) {
            count--;
          }
          map.put(arr[left], n + 1);
        }
        left++;
      }
    }
    return res;
  }
}

