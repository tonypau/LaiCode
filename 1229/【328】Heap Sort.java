/*
  first, build a max heap in input array.
  second, the top element will be the max one after first step. then swap it with the last element and 
    recursively call heapify exclusive with the last element which is already in its right position
  third, repeat the second step, until all are in their right positions.
*/

public class Solution {
  public int[] heapsort(int[] array) {
    int n = array.length;
    
    // build heap (rearrange)
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(array, n, i);
    }
    
    // repeat call recursively
    for (int i = n - 1; i >= 0; i--) {
      swap(array, i, 0);
      // NOTICE. the second parameter is not n cuz the last element has been in its right position.
      heapify(array, i, 0);
    }
    return array;
  }
  
  private void heapify(int[] array, int n, int i) {
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    
    // NOTICE: swap after check both left and right child.
    if (left < n && array[left] > array[largest]) {
      largest = left;
    }
    if (right < n && array[right] > array[largest]) {
      largest = right;
    }
    if (largest != i) {
      swap(array, largest, i);
      // recursively check the affected subtree.
      heapify(array, n, largest);
    }
  }
  
  private void swap(int[] array, int i, int j) {
    int tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}


// tiem O(nlogn)
// space O(1)
