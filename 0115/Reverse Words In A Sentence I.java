public class Solution {
  public String reverseWords(String input) {
    if (input == null || input.length() == 0) return input;
    int i = 0;
    int j = 0;
    char[] arr = input.toCharArray();
    while (j < arr.length) {
      while (j < arr.length && arr[j] != ' ') {
        j++;
      }
      reverse(arr, i, j - 1);
      i = j + 1;
      j = i;
    }
    reverse(arr, 0, arr.length - 1);
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

