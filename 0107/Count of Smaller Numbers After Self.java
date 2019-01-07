/*
【427】
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
*/


// Traverse from nums[len - 1] to nums[0], and build a binary search tree, whose TreeNode stores:

// val: value of nums[i]
// count: the number of smaller numbers on the right

public class Solution {
  public List<Integer> countSmaller(int[] nums) {
    List<Integer> res = new ArrayList<>();
    if (nums == null) return null;
    if (nums.length == 0) return res;
    TreeNode root = new TreeNode(nums[nums.length - 1]);
    res.add(0);
    for (int i = nums.length - 2; i >= 0; i--) {
      int count = insertNode(root, nums[i]);
      res.add(count);
    }
    Collections.reverse(res);
    return res;
  }
  
  private int insertNode(TreeNode root, int val) {
    int thisCount = 0;
    while (true) {
      if (val <= root.key) {
        root.count++;
        if (root.left == null) {
          root.left = new TreeNode(val);
          break;
        } else {
          root = root.left;
        }
      } else {
        thisCount += root.count;
        if (root.right == null) {
          root.right = new TreeNode(val);
          break;
        } else {
          root = root.right;
        }
      } 
    }
    return thisCount;
  }
  
  static class TreeNode {
    int key;
    int count = 1;
    TreeNode left;
    TreeNode right;
    TreeNode(int key) {
      this.key = key;
    }
  }
}
