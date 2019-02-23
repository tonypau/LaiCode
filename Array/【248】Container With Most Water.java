// two pointers
// each time consider one condition
// move the smaller one, eliminate it
public class Solution {
  public int maxArea(int[] height) {
    if (height == null || height.length <= 1) {
      return 0;
    }
    int i = 0;
    int j = height.length - 1;
    int res = 0;
    while (i < j) {
      res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
      if (height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }
    return res;
  }
}

