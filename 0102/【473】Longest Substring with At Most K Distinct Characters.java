/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.
*/

public class Solution {
  public int lengthOfLongestSubstringKDistinct(String input, int k) {
    if (input == null || k == 0) return 0;
    if (input.length() <= k) return input.length(); // NOTICE this corner case!
    
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
      while (count == k + 1 || (count <= k && i == arr.length - 1 && left < arr.length)) {
        if (count == k + 1) {
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


// After modification,
public class Solution {
  public int lengthOfLongestSubstringKDistinct(String input, int k) {
    if (input == null || k == 0) return 0;
    if (input.length() <= k) return input.length();
    Map<Character, Integer> map = new HashMap<>();
    int left = 0;
    int maxLen = 0;
    for (int i = 0; i < input.length(); i++) {
      Integer num = map.get(input.charAt(i));
      if (num == null) map.put(input.charAt(i), 1);
      else map.put(input.charAt(i), num + 1);
      // we use map.size() instead of count
      while (map.size() > k) {
        Integer rmCount = map.get(input.charAt(left));
        if (rmCount == 1) {
          map.remove(input.charAt(left));
        } else {
          map.put(input.charAt(left), rmCount - 1);
        }
        left++;
      }
      // put updating maxLen outside the while loop
      maxLen = Math.max(maxLen, i - left + 1);
    }
    return maxLen;
  }
}
