/*
【475】
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators in Ascending order. The valid operators are +, - and *.


Example 1

Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2

Input: "2\*3-4\*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
*/

// divide into left and right recursion
public class Solution {
  public List<Integer> diffWaysToCompute(String input) {
    List<Integer> res = new ArrayList<>();
    if (input == null || input.length() == 0) return res;
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      // each time meet operands, we do two-side recursion
      if (c == '-' || c == '+' || c == '*') {
        List<Integer> left = diffWaysToCompute(input.substring(0, i));
        List<Integer> right = diffWaysToCompute(input.substring(i + 1));
        for (int l : left) {
          for (int r : right) {
            if (c == '-') res.add(l - r);
            else if (c == '+') res.add(l + r);
            else res.add(l * r);
          }
        }
      }
    }
    // when res is empty after for-loop, it is the time that input is only one number
    if (res.size() == 0) res.add(Integer.valueOf(input));
    Collections.sort(res);
    return res;
  }
}
