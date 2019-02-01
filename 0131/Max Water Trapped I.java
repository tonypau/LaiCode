// O(n),O(1)
public class Solution {
  public int maxTrapped(int[] array) {
    int i = 0;
    int j = array.length - 1;
    int leftMax = 0;
    int rightMax = 0;
    int max = 0;
    while (i <= j) {
      leftMax = Math.max(leftMax, array[i]);
      rightMax = Math.max(rightMax, array[j]);
      if (leftMax < rightMax) {
        max += leftMax - array[i];
        i++;
      } else {
        max += rightMax - array[j];
        j--;
      }
    }
    return max;
  }
}

