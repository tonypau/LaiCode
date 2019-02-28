public class Solution {
  public int[] countArray(int[] array) {
    int[] index = init(array);
    int[] count = new int[array.length];
    int[] helper = new int[array.length];
    mergeSort(array, index, helper, count, 0, array.length - 1);
    return count;
  }
  
  private int[] init(int[] array) {
    int[] indices = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      indices[i] = i;
    }
    return indices;
  }
  
  private void mergeSort(int[] array, int[] index, int[] helper, int[] count, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(array, index, helper, count, left, mid);
    mergeSort(array, index, helper, count, mid + 1, right);
    merge(array, index, helper, count, left, mid, right);
  }
  
  private void merge(int[] array, int[] index, int[] helper, int[] count, int left, int mid, int right) {
    for (int i = left; i <= right; i++) {
      helper[i] = index[i];
    }
    int leftIndex = left;
    int rightIndex = mid + 1;
    int cur = left;
    while (leftIndex <= mid) {
      if (rightIndex > right || array[helper[leftIndex]] <= array[helper[rightIndex]]) {
        count[helper[leftIndex]] += (rightIndex - mid - 1);
        index[cur++] = helper[leftIndex++];
      } else {
        index[cur++] = helper[rightIndex++];
      }
    }
  }
}

