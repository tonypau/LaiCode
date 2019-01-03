/*
Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences. If the character does not has any adjacent, repeated occurrences, it is not changed.

Assumptions

The string is not null

The characters used in the original string are guaranteed to be ‘a’ - ‘z’

Examples

“abbcccdeee” → “ab2c3de3”
*/

public class Solution {
  public String compress(String input) {
    if (input == null || input.length() == 0) return input;
    char[] arr = input.toCharArray();
    int i = 0;
    int j = 0;
    while (i < arr.length && j < arr.length) {
      int count = 0;
      arr[i] = arr[j];
      while (j < arr.length && arr[i] == arr[j]) {
        j++;
        count++;
      }
      i++;
      if (count > 1) {
        String countStr = Integer.toString(count);
        for (int k = 0; k < countStr.length(); i++, k++) {
          arr[i] = countStr.charAt(k);
        }
      }
    }
    return new String(arr, 0, i);
  }
}
