public class Solution {
  public String deDup(String input) {
    if (input == null || input.length() == 0) return input;
    int slow = -1;
    int fast = 0;
    char[] arr = input.toCharArray();
    while (fast < arr.length) {
      if (slow == -1 || arr[fast] != arr[slow]) {
        arr[++slow] = arr[fast++];
      } else {
        while (fast < arr.length && arr[fast] == arr[slow]) {
          fast++;
        }
        slow--;
      }
    }
    return new String(arr, 0, slow + 1);
  }
}

