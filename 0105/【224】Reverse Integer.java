/*
 Reverse digits of an integer.

        Assumptions
If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
        Examples
            Input:      23
            Output:   32

            Input:     -14
            Output:  -41
*/

public class Solution {
  public int reverse(int x) {
    if (x == -2147483648) return 0;
    if (x < 0) return -1 * helper(-1 * x);
    else return helper(x);
  }
  
  private int helper(int x) {
    char[] arr = String.valueOf(x).toCharArray();
    reverse(arr);
    Long num = Long.valueOf(new String(arr));
    if (num > Long.valueOf(Integer.MAX_VALUE)) return 0;
    else return num.intValue();
  }
  
  private void reverse(char[] arr) {
    int i = 0;
    int j = arr.length - 1;
    while (i < j) {
      char tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
      i++;
      j--;
    }
  }
}


/*
1,000,000,003
2,147,483,648
*/
