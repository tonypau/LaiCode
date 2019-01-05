/*
Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. 
If you want a challenge, please do not see below and ask yourself what are the possible input cases. 
Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
You are responsible to gather all the input requirements up front.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, 
and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number,
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, 
or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. 
If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

public class Solution {
  public int atoi(String str) {
    String s = cleanSpaces(str);
    return helper(s);
  }
  
  private String cleanSpaces(String str) {
    char[] arr = str.toCharArray();
    // find first non-space
    int fast = 0;
    while (fast < arr.length) {
      if (arr[fast] != ' ') break;
      else fast++;
    }
    int slow = 0;
    while (fast < arr.length) {
      arr[slow++] = arr[fast++];
    }
    return new String(arr);
  }

  private int helper(String s) {
    int i = 0;
    while (i < s.length()) {
      char cur = s.charAt(i);
      if ((cur == '-' && i == 0) || cur >= '0' && cur <= '9') {
        i++;
      } else {
        break;
      }
    }
    if (i == 0) return 0;
    Long num = Long.valueOf(s.substring(0, i));
    if (num > Long.valueOf(Integer.MAX_VALUE)) {
      return Integer.MAX_VALUE;
    } else if (num < Long.valueOf(Integer.MIN_VALUE)) {
      return Integer.MIN_VALUE;
    } else {
      return num.intValue();
    }
  }
  
}




//-3425*2341
