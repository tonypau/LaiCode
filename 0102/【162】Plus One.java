/*
Given a non-negative number represented as an array of digits, plus one to the number.

Input: [2, 5, 9]

Output: [2, 6, 0]
*/

public class Solution {
  public int[] plus(int[] digits) {
    if (digits == null || digits.length == 0) {
      return new int[0];
    }
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      int sum = digits[i] + carry;
      if (sum >= 10) {
        carry = 1;
      } else {
        carry = 0;
      }
      digits[i] = sum % 10;
    }
    if (carry == 1) {
      int[] res = new int[digits.length + 1];
      arrayCopy(res, digits);
      res[0] = 1;
      return res;
    } else {
      return digits;
    }
  }
  
  private void arrayCopy(int[] res, int[] array) {
    for (int i = 0; i < array.length; i++) {
      res[i + 1] = array[i];
    }
  }
}

