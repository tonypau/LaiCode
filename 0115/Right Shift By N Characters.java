public class Solution {
  public String rightShift(String input, int n) {
    if (input.length() == 0) return input;
    int shift = n % input.length();
    char[] arr = input.toCharArray();
    reverse(arr, 0, input.length() - 1 - shift);
    reverse(arr, input.length() - shift, input.length() - 1);
    reverse(arr, 0, input.length() - 1);
    return new String(arr);
  }
  
  private void reverse(char[] arr, int i, int j) {
    while (i < j) {
      char tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
      i++;
      j--;
    }
  }
}

