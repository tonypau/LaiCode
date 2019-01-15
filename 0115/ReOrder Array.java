public class Solution {
  public int[] reorder(int[] array) {
    if (array.length == 0) return array;
    if (array.length % 2 == 0) {
      convert(array, 0, array.length - 1);
    } else {
      convert(array, 0, array.length - 2);
    }
    return array;
  }
  
  private void convert(int[] array, int left, int right) {
    int size = right - left + 1;
    if (size <= 2) return;
    int mid = left + size / 2;
    int lm = left + size / 4;
    int rm = left + size * 3 / 4;
    reverse(array, lm, mid - 1);
    reverse(array, mid, rm - 1);
    reverse(array, lm, rm - 1);
    convert(array, left, left + 2 * (lm - left) - 1);
    convert(array, left + 2 * (lm - left), right);
  }
  
  private void reverse(int[] arr, int i, int j) {
    while (i < j) {
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
      i++;
      j--;
    }
  }
}

