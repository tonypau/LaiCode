/*
Three key insights:
1) if two elements share the same "max", we can only maintain the one with the smaller "a"
2) if <a, m> is a simplified candidate, "a" is the lowest ending of ascending subsequence of length "m"
3) the trend of "a" is the same with the trend "m". for example, for <a1, m1> and <a2, m2>, if a1 < a2, then m1 < m2.


So we can use binary search to find the smallest larger element when update the max array each loop

for example, 7 2 3 1 5 8 9 6
*/

public class Solution {
  public int longest(int[] array) {
    if (array == null || array.length == 0) return 0;
    int[] refine = new int[array.length + 1];
    refine[1] = array[0];
    int rightMost = 1;
    for (int i = 1; i < array.length; i++) {
      int index = helper(refine, 1, rightMost, array[i]);
      if (index == rightMost) refine[++rightMost] = array[i];
      else refine[index + 1] = array[i]; 
    }
    return rightMost;
  }
  
  private int helper(int[] refine, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (refine[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return right;
  }
}

