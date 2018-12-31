/*
  loop from i = 1 to n-1
  pick arr[i] and insert it into sorted sequence arr[0...i-1]
  
  O(n^2)
  O(1)
*/

public class Solution {
  public int[] sort(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }
    int n = array.length;
    for (int i = 1; i < n; i++) {
      // pick arr[i]
      int key = array[i];
      int j = i - 1;
      // move all elements larger than arr[i] to one position ahead.
      while (j >= 0 && array[j] > key) {
        array[j + 1] = array[j];
        j--;
      }
      // insert into arr[0...i-1]
      array[j + 1] = key;
    }
    return array;
  }
}

