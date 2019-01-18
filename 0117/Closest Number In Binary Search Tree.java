// cruel comparison..
// my version.....
public class Solution {
  public int closest(TreeNode root, int target) {
    if (root == null) return -1;
    int[] res = new int[]{Integer.MAX_VALUE};
    helper(root, res, target);
    return res[0];
  }
  
  private void helper(TreeNode root, int[] res, int target) {
    if (root == null) {
      return;
    }
    if (root.key == target) {
      res[0] = root.key;
      return;
    }
    // the two large if parts can be compressed into just two lines
    if (root.key > target) {
      if (root.left != null && Math.abs(root.key - target) > Math.abs(root.left.key - target)) {
        if (Math.abs(root.left.key - target) < Math.abs(res[0] - target)) {
          res[0] = root.left.key;
        }
      } else {
        if (Math.abs(root.key - target) < Math.abs(res[0] - target)) {
          res[0] = root.key;
        }
      }
      helper(root.left, res, target);
    }
    if (root.key < target) {
      if (root.right != null && Math.abs(root.key - target) > Math.abs(root.right.key - target)) {
        if (Math.abs(root.right.key - target) < Math.abs(res[0] - target)) {
          res[0] = root.right.key;
        }
      } else {
        if (Math.abs(root.key - target) < Math.abs(res[0] - target)) {
          res[0] = root.key;
        }
      }
      helper(root.right, res, target);
    }
  }
}

// somebody else's version..
// recursion
public class Solution {
  public int closest(TreeNode root, int target) {
    if (root.key == target) return root.key;
  // first get where to go
    TreeNode next = root.key > target ? root.left : root.right;
    if (next == null) {
      return root.key;
    }
    int res = closest(next, target);
    return Math.abs(res - target) < Math.abs(root.key - target) ? res : root.key;
  }
}

// iterative
public class Solution {
  public int closest(TreeNode root, int target) {
    int closest = root.key;
    while (root != null) {
      if (Math.abs(closest - target) > Math.abs(root.key - target)) {
        closest = root.key;
      }    
      root = root.key < target ? root.right : root.left;
    }
    return closest;
  }
}


