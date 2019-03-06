// tc: O(n)
public class Solution {
  public String getNextPermutation(String input) {
    char[] arr = input.toCharArray();
    int i = arr.length - 1;
    while (i > 0) {
      if (arr[i] > arr[i - 1]) {
        break;
      }
      i--;
    }
    if (i == 0) {
      return "BIGGEST";
    } else {
      int val = arr[i - 1];
      int j = arr.length - 1;
      while (j >= i) {
        if (arr[j] > val) {
          break;
        }
        j--;
      }
      swap(arr, i - 1, j);
      reverseSort(arr, i, arr.length - 1);
    }
    return new String(arr);
  }
  
  private void reverseSort(char[] arr, int left, int right) {
    for (int i = left; i <= right; i++) {
      swap(arr, left++, right--);
    }  
  }
  
  private void swap(char[] nums, int i, int j) {
    char tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
