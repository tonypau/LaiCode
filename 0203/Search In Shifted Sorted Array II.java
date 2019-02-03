// Due to array includes duplicate numbers,
// when the mid one is the same with left one, we cannot ensure which part contains target, each side may contain it
// but at least we can exclude the left one each time
public class Solution {
  public int search(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;    
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      } 
      if (array[left] < array[mid]) {
        if (array[left] <= target && target <= array[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else if (array[left] > array[mid]) {
        if (array[mid] <= target && target <= array[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      } else {
        left++;
      }
    }
    return -1;
  }
}
