public class Solution {
  public int[] mergeSort(int[] array) {
    if (array == null || array.length == 0) return array;
    // allocate helper array to help merge step,
    // so that we gurantee no more than O(n) space is used
    // the space complexity is O(n) in this case.
    int[] helper = new int[array.length];
    mergeSort(array, helper, 0, array.length - 1);
    return array;
  }
  
  private void mergeSort(int[] array, int[] helper, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(array, helper, left, mid);
    mergeSort(array, helper, mid + 1, right);
    combine(array, helper, left, mid, mid + 1, right);
  }
  
  private void combine(int[] array, int[] helper, int leftL, int rightL, int leftR, int rightR) {
  // copy the content to helper array and we will merge from the helper array
    for (int i = 0; i < array.length; i++) {
      helper[i] = array[i];
    }
    int i = leftL;
    while (leftL <= rightL && leftR <= rightR) {
      if (helper[leftL] < helper[leftR]) {
        array[i++] = helper[leftL++];
      } else {
        array[i++] = helper[leftR++];
      }
    }
    while (leftL <= rightL) {
      array[i++] = helper[leftL++];
    }
    // if there are some elements at right side, we do not need to copy them because they are already in their position.
    // while (leftR <= rightR) {
      // array[i++] = helper[leftR++];
    // }
  }
}

