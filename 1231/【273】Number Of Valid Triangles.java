/*
  fix i and j and find k, the rightmost element that arr[i] + arr[j] > arr[k - 1], excluding k
  O(n^2)
*/

public class Solution {
  public int numOfTriangles(int[] array) {
    int len = array.length;
    Arrays.sort(array);
    int res = 0;
    for (int i = 0; i < len - 2; i++) {
      int k = i + 2;
      for (int j = i + 1; j < len - 1; j++) {
        while (k < len && array[i] + array[j] > array[k]) {
          k++;
        }
        // NOTICE: kth element does not meet arr[i] + arr[j] > arr[k], it should be arr[i] + arr[j] > arr[k - 1],
        //          so need to minus an extra one here.
        res += k - j - 1;
      }
    }
    return res;
  }
}

