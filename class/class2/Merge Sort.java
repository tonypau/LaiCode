public class Solution {
  public int[] mergeSort(int[] array) {
    if (array == null || array.length == 0) return array;
    int[] helper = new int[array.length];
    mergeSort(array, helper, 0, array.length - 1);
    return array;
  }
  
  private void mergeSort(int[] array, int[] helper, int left, int right) {
    // NOTE!!! do not forget ==
    // when L
    //      R
    if (left >= right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(array, helper, left, mid);
    mergeSort(array, helper, mid + 1, right);
    merge(array, helper, left, mid, mid + 1, right);
  }
  
  private void merge(int[] array, int[] helper, int leftL, int rightL, int leftR, int rightR) {
    for (int i = leftL; i <= rightR; i++) {
      helper[i] = array[i];
    }
    int index = leftL;
    while (leftL <= rightL && leftR <= rightR) {
      if (helper[leftL] < helper[leftR]) {
        array[index++] = helper[leftL++];   
      } else {
        array[index++] = helper[leftR++];   
      }
    }
    while (leftL <= rightL) {
      array[index++] = helper[leftL++];
    }
  }
}
