// there is a timeout problem with the submission
// why?

public class Solution {
  public int search(int[] array, int target) {
    if (array == null || array.length == 0) return -1;
    int index = findTurningPoint(array);
    if (array[index] == target) return index;
    int l = 0;
    int r = index - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    l = index + 1;
    r = array.length - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        r = mid + 1;
      } else {
        l = mid - 1;
      }
    }
    return -1;
  }
  
  private int findTurningPoint(int[] array) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (mid == 0 || mid == array.length - 1) return mid;
      if (array[mid - 1] < array[mid] && array[mid + 1] < array[mid]) {
        return mid;
      } else if (array[mid - 1] < array[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }  
}

