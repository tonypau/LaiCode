// O(logn + logk)
// first, find the largest smaller element than target.  O(logn)
// then, find kth smallest in two sorted array.   O(logk)

public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    if (array == null || array.length == 0) return array;
    int left = getLargestSmaller(array, target);
    int right = left + 1;
    int[] res = new int[k];
    helper(res, 0, array, left, right, k, target);
    return res;
  }
  
  private int getLargestSmaller(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      if (array[mid] <= target) {
        left = mid;
      } else {
        right = mid - 1;      
      }
    }
    return array[left] <= target ? left : right;
  }
  
  private void helper(int[] res, int index, int[] array, int left, int right, int k, int target) {
    // base case
    if (left < 0) {
      for (int i = index; i < res.length; i++) {
        res[i] = array[right++];
      }
      return;
    }
    if (right >= array.length) {
      for (int i = index; i < res.length; i++) {
        res[i] = array[left--];
      }
      return;
    }
    if (k == 1) {
      res[index] = Math.abs(array[left] - target) > Math.abs(array[right] - target) ? array[right] : array[left];
      return;
    }
    
    // recursive rule
    int lm = left - k / 2 + 1;
    int rm = right + k / 2 - 1;
    int lval = lm < 0 ? Integer.MAX_VALUE : array[lm];
    int rval = rm >= array.length ? Integer.MAX_VALUE : array[rm];
    if (Math.abs(lval - target) > Math.abs(rval - target)) {
      for (int i = right; i <= rm; i++) res[index++] = array[i];
      helper(res, index, array, left, rm + 1, k - k / 2, target);
    } else {
      for (int i = left; i >= lm; i--) res[index++] = array[i];
      helper(res, index, array, lm - 1, right, k - k / 2, target);
    }
  }
}

