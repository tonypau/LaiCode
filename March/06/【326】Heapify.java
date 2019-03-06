// tc: O(n)
// sc: O(1)
public class Solution {
  public int[] heapify(int[] array) {
    if (array == null || array.length == 0) return array;
    int end = array.length - 1;
    int start = (end - 1) / 2;  // start from the parent of the last element
    while (start >= 0) {
      siftDown(array, start, end);
      start--;
    }
    return array;
  }
  
  private void siftDown(int[] array, int start, int end) {
    int root = start;
    while ((root * 2 + 1) <= end) {
      int child = root * 2 + 1;
      // take the smallest of the left and right child
      if (child + 1 <= end && array[child + 1] < array[child]) {
        // then point to the right child instead
        child = child + 1;
      }
      if (array[child] < array[root]) {
        swap(array, child, root);
        // return the swapped root to test against it's new children
        root = child;
      } else {
        return;
      }
    }
  }
  
  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
