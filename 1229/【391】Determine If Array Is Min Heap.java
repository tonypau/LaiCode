/*
  the simple point compared with 【390】 is that we do not need to check if the heap is completed tree.
*/

public class Solution {
  public boolean isMinHeap(int[] array) {
    int n = array.length;
    for (int i = n / 2 - 1; i >= 0; i--) {
      int cur = i;
      int l = cur * 2 + 1;
      int r = cur * 2 + 2;
      if (l < n && array[cur] > array[l]) {
        return false;
      }
      if (r < n && array[cur] > array[r]) {
        return false;
      }
    }
    return true;
  }
}

