/*
Given two numbers represented as strings, return multiplication of the numbers as a string. The numbers can be arbitrarily large and are non-negative.

Example

Input: "19", "20"

Output: "380"
*/

public class Solution {
  public String multiply(String num1, String num2) {
    // multiply each digit and sum at the corresponding positions
    int[] arr = new int[num1.length() + num2.length()];
    for (int i = num1.length() - 1; i >= 0; i--) {
      for (int j = num2.length() - 1; j >= 0; j--) {
        arr[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
      }
    }
    // calculate each digit
    int carry = 0;
    for (int i = arr.length - 1; i >= 0; i--) {
      arr[i] = arr[i] + carry;
      carry = arr[i] / 10;
      arr[i] = arr[i] % 10;
    }
    // find front '0's, except the last one, which maybe the last result
    int index = 0;
    while (index < arr.length - 1) {
      if (arr[index] == 0) index++;
      else break;
    }
    // start appending to result string from index, which is the first non-zero element 
    String res = "";
    for (int i = index; i < arr.length; i++) {
      res += arr[i];
    }
    return res;
  }
}

