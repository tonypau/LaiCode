// Data structure: closest record result so far
// Initialize: closest = root;
// for each step: compare previous closest with cur root, which is closer, then enter into next level

// TC: O(height)
// SC: O(1)
public class Solution {
  public int closest(TreeNode root, int target) {
    int closest = root.key;
    while (root != null) {
      if (Math.abs(target - closest) > Math.abs(target - root.key)) {
        closest = root.key;
      }
      root = root.key < target ? root.right : root.left;
    }
    return closest;
  }
}
