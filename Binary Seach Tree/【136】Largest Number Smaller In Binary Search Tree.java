// Data structure: res
                   cur
// Initialization: res = Integer.MIN_VALUE
                   cur = root
// For each step:
//   case1: cur.key == target
//          cur = cur.left
//   case2: cur.key < target
//          cur = cur.right
//          res = Math.max(res, cur)
//   case3: cur.key > target
//          cur = cur.left

// TC: O(height)
// SC: O(1)
public class Solution {
  public int largestSmaller(TreeNode root, int target) {
    int res = Integer.MIN_VALUE;
    while (root != null) {
      if (root.key >= target) {
        root = root.left;
      } else {
        res = root.key;
        root = root.right;
      }
    }
    return res;
  }
}
