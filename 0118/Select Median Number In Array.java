private int findMedian(int[] array) {
    int k;
    if (array.length % 2 == 0) {
      k = array.length / 2;
    } else {
      k = array.length / 2 + 1;
    }
    int index = quickSelect(array, 0, array.length - 1, k);
    return array[index];
  }
  
  private int quickSelect(int[] array, int lo, int hi, int k) {
    int pivotVal = array[hi];
    int leftBound = lo;
    int rightBound = hi - 1;
    while (leftBound <= rightBound) {
      if (array[leftBound] <= pivotVal) {
        leftBound++;
      } else if (array[rightBound] >= pivotVal) {
        rightBound--;
      } else {
        swap(array, leftBound++, rightBound--);
      }
    }
    swap(array, leftBound, hi);
    // count the numbs that are <= pivot from lo
    int m = leftBound - lo + 1;
    // pivot is the one
    if (m == k) {
      return leftBound;
    // pivot is too small, so it must be on the right
    } else if (m < k) {
      return quickSelect(array, leftBound + 1, hi, k - m);
    // pivot is too big, so it must be on the left
    } else {
      return quickSelect(array, lo, leftBound - 1, k);
    }
  }
  
  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
