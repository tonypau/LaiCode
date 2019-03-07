// 1. 从前往后找到第一个比后一个大的数
// 2. 回头找这个连续的第一次出现
// 3. 这个数之前的保留，这个数减一，这个数之后的通通变为9. 注意，corner case，如果这个数是1，则忽略这个数，直接后面的变为9即可。

// tc: O(n)
public class Solution {
  public int monotoneIncreasingDigits(int N) {
    StringBuilder sb = new StringBuilder();
    String input = String.valueOf(N);
    int i = 0;
    while (i < input.length() - 1) {
      if (input.charAt(i) > input.charAt(i + 1)) {
        break;
      }
      i++;
    }
    if (i == input.length() - 1) {
      return N;
    } else {
      while (i >= 1) {
        if (input.charAt(i - 1) != input.charAt(i)) {
          break;
        }
        i--;
      }
      // the digits before i
      for (int j = 0; j < i; j++) {
        sb.append(input.charAt(j));
      }
      // the i-th digit
      if (input.charAt(i) != '1') {
        sb.append(input.charAt(i) - 1 - '0');
      } 
      // the digits after i
      for (int j = i + 1; j < input.length(); j++) {
        sb.append('9');
      }
    }
    return Integer.valueOf(sb.toString());
  }
}

