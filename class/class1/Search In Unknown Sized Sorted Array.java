/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class Solution {
  public int search(Dictionary dict, int target) {
    if (dict == null) return -1;
    int left = 0;
    int right = 1;
    // 如果10倍扩张，总的时间复杂度更快
    while (dict.get(right) != null && dict.get(right) < target) {
      left = right;
      right *= 2;
    }
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (dict.get(mid) == null || dict.get(mid) > target) {
        right = mid - 1;
      } else if (dict.get(mid) == target) {
        return mid;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}

