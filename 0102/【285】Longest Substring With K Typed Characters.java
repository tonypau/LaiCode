/*
Given a string, return the longest contiguous substring that contains exactly k type of characters.

Return null if there does not exist such substring.

Assumptions:

The given string is not null.
k >= 0.
Examples:

input = "aabcc", k = 3, output = "aabcc".
input = "aabcccc", k = 2, output = "bcccc".
*/

// sliding window
public class Solution {
  public String longest(String input, int k) {
    // corner case has multiple conditions.
		if (input == null || input.length() < k) return null;
    if (k == 0) return "";
    
		char[] arr = input.toCharArray();
		Map<Character, Integer> map = new HashMap<>();  
		int left = 0;
		int maxLen = Integer.MIN_VALUE;
		int count = 0;
		String res = null;
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
      // NOTICE: two conditions.
      // 1) count == k + 1: in this case, we take i-1 as right bound
      // 2) count == k && i == arr.length - 1: in this case, we take i as right bound
			while (count == k + 1 || (i == arr.length - 1 && count == k)) {
        // handle these two cases respectively
				if (count == k + 1) {
					if (maxLen < i - left) {
            maxLen = i - left;
						res = input.substring(left, i);
					}
				} else {
					if (maxLen < i - left + 1) {
						maxLen = i - left + 1;
						res = input.substring(left, i + 1);
					}	
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

