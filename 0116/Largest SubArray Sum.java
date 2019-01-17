public class Solution {
  public int largestSum(int[] array) {
    int max = array[0];
    int sum = array[0];
    for (int i = 1; i < array.length; i++) {
      sum += array[i];
      max = Math.max(max, sum);
      if (sum < 0) {
        sum = 0;
      }
    }
    return max;
  }
}

