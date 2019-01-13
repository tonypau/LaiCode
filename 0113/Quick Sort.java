public class Solution {
  public int[] quickSort(int[] array) {
    if (array == null || array.length == 0) return array;
    quickSort(array, 0, array.length - 1);
    return array;
  }
  
  private void quickSort(int[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    int index = partition(array, left, right);
    quickSort(array, left, index - 1);
    quickSort(array, index + 1, right);
  }
  
  private int partition(int[] array, int left, int right) {
    int pivot = getPivot(array, left, right);
    int pivotValue = array[pivot];
    swap(array, pivot, right);
    int leftBound = left;  
    int rightBound = right - 1; 
    while (leftBound <= rightBound) {
      if (array[leftBound] <= pivotValue) {
        leftBound++;
      } else if (array[rightBound] >= pivotValue) {
        rightBound--;
      } else {
        swap(array, leftBound++, rightBound--);
      }
    }
    // swap back to its correct position
    // the position where all elements at left are smaller and at right are larger is the correct position
    swap(array, right, leftBound);
    return leftBound;
  }
  
  private int getPivot(int[] array, int left, int right) {
    return (int) (Math.random() * (right - left) + left);
  }
  
  private void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}

