/*
  [0,i) '1'
  [i,j) '0'
  [j,k] processing part
  (k,n-1]  '1'
*/

public class Solution {
  public int[] rainbowSort(int[] array) {
    if (array == null || array.length == 0) return array;
    int i = 0;
    int j = 0;
    int k = array.length - 1;
    // NOTICE the last one when j == k should not be ignored
    while (j <= k) {
      if (array[j] == 1) {
        swap(array, j, k--);
      } else if (array[j] == 0) {
        j++;
      } else {
        swap(array, i++, j++);
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

