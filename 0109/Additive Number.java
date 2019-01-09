/*
[420]

Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.

1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
*/

public class Solution {
  public boolean isAdditiveNumber(String num) {
    if (num == null || num.length() == 0) return true;
    int n = num.length();
    for (int i = 1; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        long a = parse(num.substring(0, i));
        if (a == -1) continue;
        long b = parse(num.substring(i, j));
        if (b == -1) continue;
        if (dfs(num.substring(j), a, b)) return true;
      }
    }
    return false;
  }
  
  private boolean dfs(String s, long a, long b) {
    int n = s.length();
    if (n == 0) return true;
    for (int i = 1; i <= n; i++) {
      long c = Long.valueOf(s.substring(0, i));
      if (c == -1) continue;
      if (c == a + b && dfs(s.substring(i), b, c)) return true;
    }
    return false;
  }
  
  private long parse(String input) {
    if (!input.equals("0") && input.startsWith("0")) return -1;
    long res = 0;
    try {
      res = Long.valueOf(input);
    } catch (NumberFormatException e) {
      return -1;    
    }
    return res;
  }
}
