/*
Given a string, find the the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”, T is "ece"
*/


public class Solution {
  public int lengthOfLongestSubstringTwoDistinct(String input) {
    if (input == null) return 0;
    if (input.length() <= 2) return input.length(); 
    
    Map<Character, Integer> map = new HashMap<>();
    char[] arr = input.toCharArray();
    int left = 0;
    int maxLen = 0;
    int count = 0;
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
      while (count == 3 || (count <= 2 && i == arr.length - 1 && left < arr.length)) {
        if (count == 3) {
          if (maxLen < i - left) {
            maxLen = i - left;
          }
        } else {
          if (maxLen < i - left + 1) {
            maxLen = i - left + 1;
          }
        }
        Integer n = map.get(arr[left]);
        if (n != null) {
          if (n == 1) {
            count--;
          }
          map.put(arr[left], n - 1);
        }
        left++;
      }
    }
    return maxLen;
  }
}

