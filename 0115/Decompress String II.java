public class Solution {
  public String decompress(String input) {
    if (input.length() == 0) return input;
    int length = getLength(input);
    char[] arr = new char[length];
    int slow = 0;
    int fast = 0;
    while (fast < input.length()) {
      if (input.charAt(fast + 1) == '0') {
        fast += 2;
      } else if (input.charAt(fast + 1) == '1') {
        arr[slow++] = input.charAt(fast);
        fast += 2;
      } else {
        int num = input.charAt(fast + 1) - '0';
        while (num > 0) {
          arr[slow++] = input.charAt(fast);
          num--;
        }
        fast += 2;
      }
    }
    return new String(arr);
  }
  
  private int getLength(String input) {
    int len = input.length();
    for (int i = 1; i < input.length(); i += 2) {
      len += input.charAt(i) - '2';
    }
    return len;
  }
}

