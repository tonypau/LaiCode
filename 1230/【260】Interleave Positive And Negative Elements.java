/*
  to be reconsidered with more efficient solution.
  
  in this in-place solution, in first traversal, move all negative elements to the right part.
  then swap the odd indices and indices of right part.
*/

public class Solution {
  public int[] interleave(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }
    int s = 0;
    // e represents: all elements to the right of e are negative. (excluding e)
    int e = array.length - 1;
    while (s <= e) {
      if (array[s] < 0 && array[e] > 0) {
        swap(array, s++, e--);
      } else if (array[e] < 0) {
        e--;
      } else {
        s++;
      }
    }
    int index = 1;
    int startOfNeg = e + 1;
    if (startOfNeg <= array.length - 1) {
      while (startOfNeg < array.length && index < startOfNeg) {
        swap(array, startOfNeg, index);
        index += 2;
        startOfNeg++;
      }
    }
    return array;
  }
  
  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
