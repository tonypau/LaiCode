/*
maxLeft[i]: the max sum between [0..i]
minLeft[i]: the min sum between [0..i]
maxRight[i]: the max sum between [i..n-1]
minRight[i]: the min sum between [i..n-1]

tc: O(n)
sc: O(n)
*/
public class Solution {
  public int maxDiff(int[] array) {
    int[] maxLeft = new int[array.length];
    int[] minLeft = new int[array.length];
    int[] maxRight = new int[array.length];
    int[] minRight = new int[array.length];
    getMaxMinLeft(array, maxLeft, minLeft);
    getMaxMinRight(array, maxRight, minRight);
    
    // for each ele, we compare the diff between (the max in its left - the min in its right) and (the max in its right - the min in its left)
    int maxDiff = Integer.MIN_VALUE;
    for (int i = 0; i < array.length - 1; i++) {
      maxDiff = Math.max(maxDiff, Math.abs(maxLeft[i] - minRight[i + 1]));  
      maxDiff = Math.max(maxDiff, Math.abs(minLeft[i] - maxRight[i + 1]));
    }
    return maxDiff;
  }
  
  // preMin: the min sum between [0..i-1] including arr[i-1]
  // preMax: the max sum between [0..i-1] including arr[i-1]
  private void getMaxMinLeft(int[] array, int[] maxLeft, int[] minLeft) {
    int preMin = 0;
    int preMax = 0;
    for (int i = 0; i < array.length; i++) {
      if (i == 0) {
        maxLeft[0] = array[0];
        minLeft[0] = array[0];
        preMin = array[0];
        preMax = array[0];
      } else {
        // when preMin < 0, which means the previous sum can also be used to get a new min number.
        // when preMin > 0, which means the previous sum has no value to add to current ele.
        if (preMin < 0) {
          minLeft[i] = Math.min(minLeft[i - 1], array[i] + preMin);
          preMin += array[i];
        } else {
          minLeft[i] = Math.min(minLeft[i - 1], array[i]);
          preMin = array[i];
        }
        if (preMax > 0) {
          maxLeft[i] = Math.max(maxLeft[i - 1], array[i] + preMax);
          preMax += array[i];
        } else {
          maxLeft[i] = Math.max(maxLeft[i - 1], array[i]);
          preMax = array[i];
        }
      }
    }
  }

  // preMin: the min sum between [i+1..n-1] including arr[i+1]
  // preMax: the max sum between [i+1..n-1] including arr[i+1]
  private void getMaxMinRight(int[] array, int[] maxRight, int[] minRight) {
    int preMin = 0;
    int preMax = 0;
    for (int i = array.length - 1; i >= 0; i--) {
      if (i == array.length - 1) {
        maxRight[i] = array[i];
        minRight[i] = array[i];
        preMin = array[i];
        preMax = array[i];
      } else {
        if (preMin < 0) {
          minRight[i] = Math.min(minRight[i + 1], array[i] + preMin);
          preMin += array[i];
        } else {
          minRight[i] = Math.min(minRight[i + 1], array[i]);
          preMin = array[i];
        }
        if (preMax > 0) {
          maxRight[i] = Math.max(maxRight[i + 1], array[i] + preMax);
          preMax += array[i];
        } else {
          maxRight[i] = Math.max(maxRight[i + 1], array[i]);
          preMax = array[i];
        }
      }
    }
  }
}
