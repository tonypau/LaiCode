/*
  review of insert operation:
  add the new element to the bottom-right position, and percolate it up (compare with his parent).
  
  heap represented by an array:
    suppose parent index is i,
    then its left child index is 2i + 1,
         its right child index is 2i + 2.
*/

public class Solution {
  public int[] offerHeap(int[] array, int ele) {
    int n = array.length;
    array[n - 1] = ele;
    int i = n - 1;
    while (i > 0) {
      if (i % 2 == 0) {
        if (array[(i - 2) / 2] > array[i]) {
          swap(array, (i - 2) / 2, i);
          i = (i - 2) / 2;
        } else {
          break;
        }
      } else if (i % 2 != 0) {
        if (array[(i - 1) / 2] > array[i]) {
          swap(array, (i - 1) / 2, i);
          i = (i - 1) / 2;
        } else {
          break;
        }
      }
    }
    return array;
  }
  
  private void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}

