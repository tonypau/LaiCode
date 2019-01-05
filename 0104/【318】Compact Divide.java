/*
Given two integers a and b, return the result of a / b in String with compact format. The repeated decimal part should be identified and enclosed by "()".

Examples

0 / 2 = "0"

4 / 2 = "2"

1 / 2 = "0.5"

-14 / 12 = "-1.1(6)"

1 / 11 = "0.(09)"

1 / 0 = "NaN"

-1 / 0 = "NaN"
*/

public class Solution {
  public String divide(int a, int b) {
    if (b == 0) return "NaN";
    if (a == 0) return "0";
    if (a < 0 && b > 0) return "-" + helper(-a, b);
    if (a > 0 && b < 0) return "-" + helper(a, -b);
    if (a > 0 && b > 0) return helper(a, b);
    return helper(-a, -b);
  }
  
  // a > 0, b > 0
  private String helper(int a, int b) {
    Map<Integer, Integer> map = new HashMap<>();
    String res = "";
    res += String.valueOf(a / b);
    if (a / b * b == a) return res;  // if can be divided exactly, return res without '.'
    
    res += ".";
    int remainder = a - a / b * b;
    int index = 0;
    String decimal = "";
    // when meeting a remainder that has appeared before, 
    // then we find the repeated decimal part
    while (!map.containsKey(remainder)) {
      map.put(remainder, index);
      decimal += String.valueOf(remainder * 10 / b);
      remainder = remainder * 10 - remainder * 10 / b * b;
      index++;
    }
    int startIndex = map.get(remainder);
    int i = 0;
    // add '(', ')'
    while (i <= decimal.length()) {
      if (i == startIndex) {
        res += "(";
        res += decimal.charAt(i);
      } else if (i == decimal.length()) {
        res += ")";
        break;
      } else {
        res += decimal.charAt(i);      
      }
      i++;
    }
    // get rid of (0)
    for (int j = 0; j < res.length(); j++) {
      if (res.charAt(j) == '(' && res.charAt(j + 1) == '0' && res.charAt(j + 2) == ')') {
        return res.substring(0, j);
      } 
    } 
    return res;
  }
}

/*
14/12 = 1.166667
  1.1(6)
1/11 = 0.0909
  0.(09)
  
  
1/7

  */

