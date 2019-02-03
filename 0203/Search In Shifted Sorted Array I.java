// 不能直接用binary search，那就找可以用的那一半
public class Solution {
  public int search(int[] array, int target) {
    if (array == null || array.length == 0) return -1;
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      }
      if (array[left] <= array[mid]) {
        if (array[left] <= target && target <= array[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (array[mid] <= target && target <= array[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }
}

